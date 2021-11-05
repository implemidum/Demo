import {JetView} from "webix-jet";

export default class GroupSearchView extends JetView{
	config(){
		return {
        	rows:[
			{
				view:"toolbar", css:"subbar", padding:0,
				elements:[
					{
						height:50, css:"title", borderless:true,
						template:`<div class='header'>Music Groups</div>
							<div class='details'>( search )</div>`
					},
					{
						view:"text", id:"group:search", name:"search", label:"Search by album name"
					},
					{
						view:"button", localId:"button:add", type:"form",
						label:"Search", width:140,
						click:() => {
							this.searchGroups(this.$$("group:search").getValue());
						}
					}
				]
			},
			{
				view:"datatable",
				localId:"resultTable",
				select:true,
				autoConfig:true,
				scroll:"y",
				columns:[
					{ id:"name", header:["Name", {content:"textFilter"}], sort:"text", width:200 },
					{ id:"description", header:"Description", fillspace:true }
				]
			}
			]
		};
	}
	init(){
	}
	searchGroups(patern){
		webix.ajax().headers({
			"Content-type":"application/json"
		}).get(
			"../rest/groups?name=" + patern
		).then((data) => {
		    this.$$("resultTable").clearAll();
			this.$$("resultTable").parse(data);
		});
	}
}