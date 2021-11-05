import {JetView} from "webix-jet";
import AlbumsView from "views/albumsview";
import AlbumForm from "views/forms/albumform";
import MemberForm from "views/forms/memberform";
import {groups} from "models/groups";

export default class GroupsView extends JetView{
	config(){
		return {
			cols:[
			{
				view:"datatable",
				localId:"groupsTable",
				select:true,
				autoConfig:true,
				scroll:"y",
				columns:[
					{ id:"edit", header:"", width:35, template:"{common.editIcon()}" },
					{ id:"delete", header:"", width:35, template:"{common.trashIcon()}" },
					{ id:"name", header:["Name", {content:"textFilter"}], sort:"text", width:200 },
					{ id:"description", header:"Description", fillspace:true }
				],
				on:{
					"onItemClick":(id, e, trg) => {
						this.groupId = id;
	            		webix.ajax().headers({
			    			"Content-type":"application/json"
						}).get(
							"../rest/groups/" + this.groupId + "/albums/"
						).then((data) => {
						    this.$$("albumsTable").clearAll();
							this.$$("albumsTable").parse(data);
			      		});
	            		webix.ajax().headers({
			    			"Content-type":"application/json"
						}).get(
							"../rest/groups/" + this.groupId + "/members/"
						).then((data) => {
						    this.$$("membersTable").clearAll();
							this.$$("membersTable").parse(data);
			      		});
	        		}
				},
				onClick:{
					"wxi-trash":(e, id) => {
						webix.confirm({
							text:"The group will be deleted. <br/> Are you sure?",
							ok:"Yes", cancel:"Cancel",
							callback: res => {
								if (res){
									groups.remove(id.row);
									this.$$("albumsTable").clearAll();
									this.$$("membersTable").clearAll();
								}
							}
						});
					},
					"wxi-pencil":(e, id) => {
						this.show("groups?id="+id.row);
					}
				}
			},
			{
				rows:[
					{
						view:"toolbar", css:"subbar", padding:0,
						elements:[
							{
								css:"title", height:50, borderless:true,
								template: `<div class='header'>Albums</div>`
							},
							{
								view:"button", type:"form",
								label:"Add album", width:140,
								click:() => this.albumForm.showForm()
							}
						]
					},
					{ 
						view:"datatable",
						localId:"albumsTable",
						select:true,
						autoConfig:true,
						scroll:"y",
						columns:[
							{ id:"edit", header:"", width:35, template:"{common.editIcon()}" },
							{ id:"delete", header:"", width:35, template:"{common.trashIcon()}" },
							{ id:"title", header:["Title", {content:"textFilter"}], sort:"text", width:200 },
							{ id:"description", header:"Description", fillspace:true }
						],
						onClick:{
							"wxi-trash":(e, id) => {
								webix.confirm({
									text:"The album will be deleted. <br/> Are you sure?",
									ok:"Yes", cancel:"Cancel",
									callback: res => {
										if (res)
											this.app.callEvent("album:delete",[id.row]);
									}
								});
							},
							"wxi-pencil":(e, id) => {
								//show form
								const item = this.$$("albumsTable").getItem(id);
								this.app.callEvent("albumform:fill", [item]);
							}
						}
					},
					{
						view:"toolbar", css:"subbar", padding:0,
						elements:[
							{
								css:"title", height:50, borderless:true,
								template: `<div class='header'>Group Members</div>`
							},
							{
								view:"button", type:"form",
								label:"Add member", width:140,
								click:() => this.memberForm.showForm()
							}
						]
					},
					{
						view:"datatable",
						localId:"membersTable",
						select:true,
						autoConfig:true,
						scroll:"y",
						columns:[
							{ id:"edit", header:"", width:35, template:"{common.editIcon()}" },
							{ id:"delete", header:"", width:35, template:"{common.trashIcon()}" },
							{ id:"firstName", header:"First Name", sort:"text", width:200 },
							{ id:"lastName", header:"Last Name", sort:"text", width:200 },
							{ id:"country", header:"Country", sort:"text", fillspace:true }
						],
						onClick:{
							"wxi-trash":(e, id) => {
								webix.confirm({
									text:"Member of the group will be deleted. <br/> Are you sure?",
									ok:"Yes", cancel:"Cancel",
									callback: res => {
										if (res)
											this.app.callEvent("member:delete",[id.row]);
									}
								});
							},
							"wxi-pencil":(e, id) => {
								//show form
								const item = this.$$("membersTable").getItem(id);
								this.app.callEvent("memberform:fill", [item]);
							}
						}
					}
				]
			}
			]
		};
	}
	init(){
		this.groupId = 0;
		this.albumForm = this.ui(AlbumForm);
		this.memberForm = this.ui(MemberForm);
		this.$$("groupsTable").sync(groups);
		
		// save values from album form
		this.on(this.app, "album:save", values => {
			delete values.songs;
			if (values.id) {
				// update album PUT:/rest/groups/{groupId}/albums/{id}
				webix.ajax().headers({
    				"Content-type":"application/json"
				}).put(
					"../rest/groups/" + this.groupId + "/albums/" + values.id, JSON.stringify(values)
				).then((data) => {
        			webix.ajax().headers({
			    		"Content-type":"application/json"
					}).get(
						"../rest/groups/" + this.groupId + "/albums/"
					).then((data) => {
					    this.$$("albumsTable").clearAll();
						this.$$("albumsTable").parse(data);
			      	});
      			});
			}
			else {
				// add new album POST:/rest/groups/{groupId}/albums
				webix.ajax().headers({
    				"Content-type":"application/json"
				}).post(
					"../rest/groups/" + this.groupId + "/albums/", JSON.stringify(values)
				).then((data) => {
					webix.ajax().headers({
			    		"Content-type":"application/json"
					}).get(
						"../rest/groups/" + this.groupId + "/albums/"
					).then((data) => {
					    this.$$("albumsTable").clearAll();
						this.$$("albumsTable").parse(data);
			      	});
      			});
			}
		});
		this.on(this.app, "album:delete", id => {
			// update album DELETE:/rest/albums/{id}
			webix.ajax().headers({
    			"Content-type":"application/json"
			}).del(
				"../rest/albums/" + id
			).then(() => {
        		webix.ajax().headers({
		    		"Content-type":"application/json"
				}).get(
					"../rest/groups/" + this.groupId + "/albums/"
				).then((data) => {
				    this.$$("albumsTable").clearAll();
					this.$$("albumsTable").parse(data);
		      	});
      		});
		});
		
		// save values from member form
		this.on(this.app, "member:save", values => {
			if (values.id) {
				// update album PUT:/rest/groups/{groupId}/members/{id}
				webix.ajax().headers({
    				"Content-type":"application/json"
				}).put(
					"../rest/groups/" + this.groupId + "/members/" + values.id, JSON.stringify(values)
				).then((data) => {
        			webix.ajax().headers({
			    		"Content-type":"application/json"
					}).get(
						"../rest/groups/" + this.groupId + "/members/"
					).then((data) => {
					    this.$$("membersTable").clearAll();
						this.$$("membersTable").parse(data);
			      	});
      			});
			}
			else {
				// add new album POST:/rest/groups/{groupId}/members
				webix.ajax().headers({
    				"Content-type":"application/json"
				}).post(
					"../rest/groups/" + this.groupId + "/members/", JSON.stringify(values)
				).then((data) => {
					webix.ajax().headers({
			    		"Content-type":"application/json"
					}).get(
						"../rest/groups/" + this.groupId + "/members/"
					).then((data) => {
					    this.$$("membersTable").clearAll();
						this.$$("membersTable").parse(data);
			      	});
      			});
			}
		});
		this.on(this.app, "member:delete", id => {
			// update album DELETE:/rest/members/{id}
			webix.ajax().headers({
    			"Content-type":"application/json"
			}).del(
				"../rest/members/" + id
			).then(() => {
        		webix.ajax().headers({
		    		"Content-type":"application/json"
				}).get(
					"../rest/groups/" + this.groupId + "/members/"
				).then((data) => {
				    this.$$("membersTable").clearAll();
					this.$$("membersTable").parse(data);
		      	});
      		});
		});
		
	}
	urlChange(){
	}
}