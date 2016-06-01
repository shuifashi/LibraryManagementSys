<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Login</title>


    <!-- <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet"> -->
    <link rel="stylesheet" type="text/css" href="../common.css" />
    <link rel="stylesheet" type="text/css" href="./register.css" />


</head>

<body class="">
    


<div id="content" role="main">
    
    <div class="container">
        <div class="row">
            <div class="col-sm-8 col-sm-offset-2 col-md-6 col-md-offset-3 m-t-3">
                <div class="card">
                    <div class="card-block">
                      <!--   <a href="/" class="image-link m-a-2" style="display: block;text-align: center;">
                            <img style="width: 100px;" src="" alt="Our Logo">
                        </a> -->
                            <div class="p-a-1">
                                <form method="post" accept-charset="utf-8" action="register" novalidate>
                                   <!--  <div style="display:none;">
                                        <input type="hidden" name="_method" value="POST" class="form-control">
                                        <input type="hidden" name="_csrfToken" class="form-control">
                                    </div> -->
                                    <div class="form-group userid">
                                        <label for="userId">UserId</label>
                                        <input type="userId" name="user.userId" placeholder="UserId" tabindex="1" class="form-control form-control-lg" id="usernId">
                                    </div>   
                                    <div class="form-group email">
                                        <label for="useremail">Email</label>
                                        <input type="email" name="user.email" placeholder="Email" tabindex="2" class="form-control form-control-lg" id="useremail">
                                    </div>
                                    <div class="form-group username">
                                        <label for="username">Username</label>
                                        <input type="username" name="user.username" placeholder="Username" tabindex="3" class="form-control form-control-lg" id="username">
                                    </div>           
                                    <div class="form-group password">
                                        <label for="password">Password</label>
                                        <input type="password" name="user.password" placeholder="Password" tabindex="4" class="form-control form-control-lg" id="password">
                                    </div>
                                    <div class="form-group repassword">
                                        <label for="password">Repassword</label>
                                        <input type="password" name="repassword" placeholder="Repassword" tabindex="5" class="form-control form-control-lg" id="repassword">
                                    </div>                    
                                  
                                    </div>
                
                                    <!-- <input type="hidden" name="redirect" id="redirect" value="/" class="form-control">   -->
                                    <input type="submit" value="Create a new account" class="btn btn-primary btn-block" tabindex="3">
                
                               <!--  <div style="display:none;">
                                    <input type="hidden" name="_Token[fields]" class="form-control">
                                    <input type="hidden" name="_Token[unlocked]" value="" class="form-control">
                                </div> -->
                                </form>
                            </div>
                        <div class="text-xs-center m-a-1">
                            <small>Already have an account?</small>
                            <p class="small"><a href="/" tabindex="5" class="xs-padding-right-small">Login in</a> or <a href="/users/work_on_projects" tabindex="5" class="xs-padding-left-small">Just Have a Look</a></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div> <!-- close #content -->


    <script src="../jquery.js"></script>
    <!-- <script src="//api.filepicker.io/v2/filepicker.js"></script> -->
    <script src="../bootstrap/js/bootstrap.js"></script>
    <script src="../common.js"></script>
    <script src="../app.js"></script>

</body>
</html>

