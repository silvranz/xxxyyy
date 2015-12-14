package com.fresearch.oversign.parameter.workspace;

public class Event{
	private String triggerElementId;
	private String triggerOn;
	private String triggerEventCategory;
	private String affectingElementID;
	private String affectingElementType;
	private String actionCategory;
	private AddParams additional_params;
	private String _triggerOn;
	private String _action;
	private String action;
	
	public Event(){}
	
	public void setTriggerElementId(String triggerElementId){
		this.triggerElementId = triggerElementId;
	}
	public String getTriggerElementId(){
		return triggerElementId;
	}
	public void setTriggerOn(String triggerOn){
		this.triggerOn = triggerOn;
	}
	public String getTriggerOn(){
		return this.triggerOn;
	}
	public void setTriggerEventCategory(String triggerEventCategory){
		this.triggerEventCategory = triggerEventCategory;
	}
	public String getTriggerEventCategory(){
		return triggerEventCategory;
	}
	public void setAffectingElementID(String affectingElementID){
		this.affectingElementID = affectingElementID;
	}
	public String getAffectingElementID(){
		return this.affectingElementID;
	}
	public void setAffectingElementType(String affectingElementType){
		this.affectingElementType = affectingElementType;
	}
	public String getAffectingElementType(){
		return affectingElementType;
	}
	public void setActionCategory(String actionCategory){
		this.actionCategory = actionCategory;
	}
	public String getActionCategory(){
		return this.actionCategory;
	}
	public void setAdditional_params(AddParams additional_params){
		this.additional_params = additional_params;
	}
	public AddParams getAdditional_params(){
		return additional_params;
	}
	public void set_triggerOn(String _triggerOn){
		this._triggerOn = _triggerOn;
	}
	public String get_triggerOn(){
		return this._triggerOn;
	}
	public void set_action(String _action){
		this._action = _action;
	}
	public String get_action(){
		return _action;
	}
	public void setAction(String action){
		this.action = action;
	}
	public String getAction(){
		return this.action;
	}
}