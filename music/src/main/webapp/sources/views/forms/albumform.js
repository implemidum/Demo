import {JetView} from "webix-jet";


export default class AlbumForm extends JetView{
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
					{view:"text", name:"title", label:"Title" },
					{view:"text", name:"description", label:"Description"},
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
									this.saveAlbum(this.$$("form").getValues());
									this.hideForm();
								}
							}
						},
						{}
						]
					}
				],
				rules:{
					title:webix.rules.isNotEmpty,
					description:webix.rules.isNotEmpty
				}
			}
		};
	}
	urlChange(form){
	}
	saveAlbum(values){
		this.app.callEvent("album:save", [values]);
	}
	init(view){
		this.form = view.getBody();
		this.on(this.app, "albumform:fill", values => {
			view.show();
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