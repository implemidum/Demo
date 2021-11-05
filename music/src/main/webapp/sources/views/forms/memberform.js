import {JetView} from "webix-jet";

export default class MemberForm extends JetView{
	config(){
		return {
			view:"window", head:false, position:"center",
			modal:true,
			body:{
				view:"form", paddingY:20, paddingX:30,
				localId:"form",
				elementsConfig:{ labelWidth:100 },
				elements:[
					{type:"header", height:45, template:"Album Editor"},
					{view:"text", name:"firstName", label:"First Name" },
					{view:"text", name:"lastName", label:"Last Name" },
					{view:"select", label:"Country", name:"countryId", id:"countryId", options:"json->../rest/countries"},
					{
						margin:10,
						cols:[
						{
							view:"button", value:"Cancel", align:"center", width:120,
							click:() => {
								this.hideForm();
							}
						},
						{
							view:"button", value:"Save", type:"form", align:"center", width:120,
							click:() => {
								if (this.$$("form").validate()){
									this.saveMember(this.$$("form").getValues());
									this.hideForm();
								}
							}
						},
						{}
						]
					}
				],
				rules:{
					firstName:webix.rules.isNotEmpty,
					lastName:webix.rules.isNotEmpty
				}
			}
		};
	}
	urlChange(form){
	}
	saveMember(values){
		this.app.callEvent("member:save", [values]);
	}
	init(view){
		this.form = view.getBody();
		this.on(this.app, "memberform:fill", values => {
			view.show();
			// values.country = values.countryId;
			this.form.setValues(values);
		});
	}
	showForm(){
		this.getRoot().show();
	}
	hideForm(){
		this.getRoot().hide();
		this.form.clear();
		this.form.clearValidation();
	}
}