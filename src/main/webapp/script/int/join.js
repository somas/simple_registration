			jQuery.validator.addMethod("regex_USERNAME_TEXT_PATTERN", function(value, element, param) {
		                       var reg = /^[0-9a-zA-Z]{5,40}$/i;
		                       return this.optional(element) || reg.test(value);
		                }, jQuery.i18n.prop("user.username.Pattern.message"));

			
			jQuery.validator.addMethod("regex_PASSWORD_TEXT_PATTERN", function(value, element, param) {
		        var reg = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{8,}$/;
		        return this.optional(element) || reg.test(value);
		   }, jQuery.i18n.prop("user.verifyPassword.FieldMatch.message"));

	

$(document).ready(
		function() { 
			$("#submit_id").click(
					function() {
						$("#success").hide();
						removeServerErrorLabels();
					})
			$("#registrationForm").validate({
								rules : {
									username: {
										regex_USERNAME_TEXT_PATTERN: "required username",				
										required: true
									},
									email: {
										maxlength:40,
										required: true,
										email: true
									},
									verifyEmail: {
										equalTo: "#email",
										required: true
									},
									password: { 
										required: true,
										regex_PASSWORD_TEXT_PATTERN: "required password"			
									},
									verifyPassword: {
										equalTo: "#password",
										required: true
									},
								},
								messages : {
									username: {
										 required: jQuery.i18n.prop("user.username.Required.message")
									},
									email: {
										 required: jQuery.i18n.prop("user.email.NotBlank.message"),
										 maxlength: jQuery.i18n.prop("user.email.MaxSize.message"),
										 email: jQuery.i18n.prop("user.email.NotBlank.message")
									},
									verifyEmail: {
										equalTo: jQuery.i18n.prop("user.verifyEmail.FieldMatch.message"),
										required: jQuery.i18n.prop("user.email.NotBlank.message")
									},
									verifyPassword: {
										equalTo:  jQuery.i18n.prop("user.verifyPassword.FieldMatch.message"),
										required: jQuery.i18n.prop("user.password.Required.message")
									},
								},
								errorClass : "has_error",
								errorPlacement : function(error, element) {
									error.insertAfter(element.parents(
											'.form-group')
											.children('label').first());
								},
								highlight : function(element, errorClass,
										validClass) {
									$(element).parents('.form-group')
											.addClass(errorClass).removeClass(
													validClass);
								},
								unhighlight : function(element, errorClass,
										validClass) {
									$(element).parents('.form-group')
											.removeClass(errorClass).addClass(
													validClass);
								},
								onfocusout : function(element) {
									if (!this.checkable(element)
											&& element.name in this.submitted) {
										this.element(element);
									}
								},
								submitHandler: function(form) {
									var postData = $("#registrationForm").serialize();
									var jqxhr = $.ajax({
										type : "POST",
										url: "registration",
										data: postData
										}).done(function(data) {
											 $("#success").show();
												debug_message("second success");
											}).fail(function(data) {
												debug_message("error");
												if(data.responseText != null) {
													var jsonErrors = $.parseJSON(data.responseText);
													$.each(jsonErrors.errors, function(idx, obj) {
														$('#serverErrorMessage').append("<li>" + JSON.stringify(obj) + "</li>");
													});
												}
										removeServerErrorLabels();
										processServerErrorMessage();
									}).always(function(data) {
										debug_message("complete");
									});
								}
							});
		});

isI18NAware = function() {
	return true;
};

function debug_message(message) {
	if (debug) {
		alert(message);
	}
}