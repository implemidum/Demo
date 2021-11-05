import {JetView} from "webix-jet";

export default class AlbumsView extends JetView{
	config(){
		return {
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
		};
	}
}