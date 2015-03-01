<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link type="text/css" rel="stylesheet" href="/portal/css/ext/bootstrap.min.css?@@TIMESTAMP@@" />
<script type="text/javascript" src="/portal/script/ext/jquery-1.11.0.min.js?@@TIMESTAMP@@"></script>
<script type="text/javascript" src="/portal/script/ext/jquery.simpletip-1.3.1.min.js"></script>
<script type="text/javascript" src="/portal/script/ext/jquery.i18n.properties-min-1.0.9.js?@@TIMESTAMP@@"></script>
<script type="text/javascript" src="/portal/script/ext/jquery.validate-1.8.1.min.js"></script>
<script type="text/javascript" src="/portal/script/int/join.js?@@TIMESTAMP@@"></script>
<script type="text/javascript" src="/portal/script/int/serverSideValidation.js?@@TIMESTAMP@@"></script>
<script type="text/javascript" src="/portal/script/int/add.i18n.capability.js?@@TIMESTAMP@@"></script>
<link type="text/css" rel="stylesheet" href="/portal/css/ext/bootstrap-responsive.min.css?@@TIMESTAMP@@"/>

<title>Simple Registration App</title>

 <div class="container">

    <div class="masthead">
        <h3 class="text-muted">Registration</h3>
      </div>

	<form id="registrationForm" class="form-horizontal">
		<div class="form-group">
		   	<label class="col-sm-2 control-label" id="ss_general_errors"></label>
		</div>
		<div id="success" class="alert alert-success" role="alert" style="display: none">Congratulation, your account has been successfully created. </div>
		<ul id="serverErrorMessage" style="display: none"></ul>
		<div class="form-group">
			<label for="username" class="col-sm-2 control-label">Username*</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="username" name="username" placeholder="Username" data-trigger="hover focus click" data-toggle="tooltip" data-placement="bottom" title="Choose 5-40 alphanumeric characters.">
				<h5><small>Choose 5-40 alphanumeric characters.</small></h5>
			</div>
		</div>
		<div class="form-group">
			<label for="email" class="col-sm-2 control-label">Email*</label>
			<div class="col-sm-4">
				<input type="email" class="form-control" id="email" name="email" placeholder="Email">
			</div>
		</div>
		<div class="form-group">
			<label for="verifyEmail" class="col-sm-2 control-label">Confirm Email*</label>
			<div class="col-sm-4">
				<input type="email" class="form-control" id="verifyEmail" name="verifyEmail" placeholder="Confirm Email">
			</div>
		</div>
		<div class="form-group">
			<label for="password" class="col-sm-2 control-label">Password*</label>
			<div class="col-sm-4">
				<input type="password" class="form-control" id="password" name="password" placeholder="Password" data-trigger="hover focus click" data-toggle="tooltip" data-placement="bottom" title="Choose 8-40 characters, with minimum 1 lower, 1 upper, 1 numeric value.">
				<h5><small>Choose 8-40 characters, with minimum 1 lower, 1 upper, 1 numeric value.</small></h5>
			</div>
		</div>
		<div class="form-group">
			<label for="verifyPassword" class="col-sm-2 control-label">Confirm Password*</label>
			<div class="col-sm-4">
				<input type="password" class="form-control" id="verifyPassword" name="verifyPassword" placeholder="Confirm Password">
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button id="submit_id" type="submit" class="btn btn-default">Register</button>
			</div>
		</div>
	</form>

      <div class="footer">
        <p>&copy; Company 2015</p>
      </div>

  </div>