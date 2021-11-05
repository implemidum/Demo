import {JetView} from "webix-jet";
import GroupsView from "views/groupsview";
import GroupForm from "views/forms/groupform";

export default class GroupsMultiView extends JetView{
	config(){
		return {
			rows:[
				{
					view:"toolbar", css:"subbar", padding:0,
					elements:[
						{
							height:50, css:"title", borderless:true,
							template:`<div class='header'>Music Groups</div>
								<div class='details'>( info & editing )</div>`
						},
						{
							view:"button", localId:"button:add", type:"form",
							label:"Add Music Group", width:140,
							click:() => this.$$("multi").setValue("formView")
						}
					]
				},
				{
					view:"multiview",
					animate:false,
					fitBiggest:true,
					localId:"multi",
					cells:[
						{ id:"gridView", $subview:GroupsView },
						{ id:"formView", $subview:GroupForm }
					],
					on:{
						onViewChange:(prev)=>{
							const button = this.$$("button:add");
							(prev === "gridView") ? button.hide() : button.show();
						}
					}
				}
			]
		};
	}
	urlChange(){
		const id = this.getParam("id");
		if (id){
			this.$$("multi").setValue("formView");
		}
		else{
			this.$$("multi").setValue("gridView");
		}
	}
}