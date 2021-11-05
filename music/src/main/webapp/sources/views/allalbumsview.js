import {JetView} from "webix-jet";
import SongForm from "views/forms/songform";
import {albums} from "models/albums";

export default class AllAlbumsView extends JetView{
	config(){
		return {
        	rows:[
			{
				view:"toolbar", css:"subbar", padding:0,
				elements:[
					{
						height:50, css:"title", borderless:true,
						template:`<div class='header'>Albums</div>
							<div class='details'>( info & editing )</div>`
					}
				]
			},
			{
				cols:[
				{
					view:"datatable",
					localId:"albumsTable",
					select:true,
					autoConfig:true,
					scroll:"y",
					columns:[
						{ id:"title", header:["Title", {content:"textFilter"}], sort:"text", width:200 },
						{ id:"group", header:["Group", {content:"textFilter"}], sort:"text", width:200 },
						{ id:"description", header:"Description", fillspace:true }
					],
					on:{
						"onItemClick":(id, e, trg) => {
							this.albumId = id;
		            		webix.ajax().headers({
				    			"Content-type":"application/json"
							}).get(
								"../rest/albums/" + this.albumId + "/songs/"
							).then((data) => {
							    this.$$("songsTable").clearAll();
								this.$$("songsTable").parse(data);
				      		});
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
							template: `<div class='header'>Songs</div>`
						},
						{
							view:"button", type:"form",
							label:"Add song", width:140,
							click:() => this.songForm.showForm()
						}
						]
					},
					{ 
						view:"datatable",
						localId:"songsTable",
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
									text:"The song will be deleted. <br/> Are you sure?",
									ok:"Yes", cancel:"Cancel",
									callback: res => {
										if (res)
											this.app.callEvent("song:delete",[id.row]);
									}
								});
							},
							"wxi-pencil":(e, id) => {
								//show form
								const item = this.$$("songsTable").getItem(id);
								this.app.callEvent("songform:fill", [item]);
							}
						}
					}
				]
            }
            ]
            }
            ]
		};
	}
	init(){
		this.albumId = 0;
		this.songForm = this.ui(SongForm);
		//this.$$("albumsTable").sync(albums);
		webix.ajax().headers({
		    "Content-type":"application/json"
		}).get(
			"../rest/albums/"
		).then((data) => {
		    this.$$("albumsTable").clearAll();
			this.$$("albumsTable").parse(data);
		});
		
		// save values from album form
		this.on(this.app, "song:save", values => {
			if (values.id) {
				// update album PUT:/rest/albums/{albumsId}/songs/{id}
				webix.ajax().headers({
    				"Content-type":"application/json"
				}).put(
					"../rest/albums/" + this.albumId + "/songs/" + values.id, JSON.stringify(values)
				).then((data) => {
        			webix.ajax().headers({
			    		"Content-type":"application/json"
					}).get(
						"../rest/albums/" + this.albumId + "/songs/"
					).then((data) => {
					    this.$$("songsTable").clearAll();
						this.$$("songsTable").parse(data);
			      	});
      			});
			}
			else {
				// add new album POST:/rest/albums/{groupId}/songs
				webix.ajax().headers({
    				"Content-type":"application/json"
				}).post(
					"../rest/albums/" + this.albumId + "/songs/", JSON.stringify(values)
				).then((data) => {
					webix.ajax().headers({
			    		"Content-type":"application/json"
					}).get(
						"../rest/albums/" + this.albumId + "/songs/"
					).then((data) => {
					    this.$$("songsTable").clearAll();
						this.$$("songsTable").parse(data);
			      	});
      			});
			}
		});
		this.on(this.app, "song:delete", id => {
			// update album DELETE:/rest/songs/{id}
			webix.ajax().headers({
    			"Content-type":"application/json"
			}).del(
				"../rest/songs/" + id
			).then(() => {
        		webix.ajax().headers({
		    		"Content-type":"application/json"
				}).get(
					"../rest/albums/" + this.albumId + "/songs/"
				).then((data) => {
				    this.$$("songsTable").clearAll();
					this.$$("songsTable").parse(data);
		      	});
      		});
		});
	}
	urlChange(){
		webix.message("CHANGE");
		// this.$$("albumsTable").sync(albums);
		webix.ajax().headers({
		    "Content-type":"application/json"
		}).get(
			"../rest/albums/"
		).then((data) => {
		    this.$$("albumsTable").clearAll();
			this.$$("albumsTable").parse(data);
		});
	}
}