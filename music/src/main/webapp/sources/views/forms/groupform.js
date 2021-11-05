import {JetView} from "webix-jet";
import {groups} from "models/groups";

export default class GroupForm extends JetView{
	config(){
		return {
		view:"form", paddingY:20, paddingX:30,
		localId:"form",
		elementsConfig:{ labelWidth:100 },
		elements:[
			{type:"header", height:45, template:"Music Group Editor"},
			{view:"text", name:"name", label:"Name" },
			{view:"text", name:"description", label:"Description"},
			{
				margin:10,
				cols:[
					{
						view:"button", value:"Cancel", align:"center", width:120,
						click:() => {
							this.getBack();
						}
					},
					{
						view:"button", value:"Save", type:"form", align:"center", width:120,
						click:() => {
							const form = this.getRoot();
							if (form.validate()){
								this.saveGroup(form.getValues());
								this.getBack();
							}
						}
					},
					{}
				]
			}
		],
		rules:{
			name:webix.rules.isNotEmpty,
			description:webix.rules.isNotEmpty
		}};
	}
	urlChange(form){
		groups.waitData.then(()=>{
			const id = this.getParam("id");
			if(id && groups.exists(id)){
				form.setValues(groups.getItem(id));
			}
		})
	}
	saveGroup(values){
		const id = values.id;
		if (id)
			groups.updateItem(id, values);
		else
			groups.add(values);
	}
	getBack(){
		// clear values and validations from the form
		const form=this.getRoot();
		form.clear();
		form.clearValidation();
		
		// show grid
		this.show("groups");
	}
	init(){
		this.$$("form").setValues(groups.getItem(id));
	}
}