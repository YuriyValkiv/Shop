function validationCorrect(vResult, vRules)
{
    vResult.style.backgroundImage = 'url("/resources/images/validYes.png")';
    vRules.style.color = '#008000';
}

function validationUnCorrect(vResult, vRules)
{
    vResult.style.backgroundImage = 'url("/resources/images/validNo.png")';
    vRules.style.color = '#ff0000';
}

function validateLogin(minLength, maxLength, inputField)
{
    var regExpression = /^[A-z0-9_]+$/;
    var vResult = document.getElementById('validateLoginResult');
    var vRules =  document.getElementById('validateLoginRules');
    if(inputField.value.length < minLength || inputField.value.length > maxLength || !inputField.value.match(regExpression))
    {
        validationUnCorrect(vResult, vRules);
        return false;
    }
    else
    {
        validationCorrect(vResult, vRules);
        return true;
    }
}

function validateEmail(inputField)
{
    var regExpression = /^[-\w.]+@([A-z0-9][-A-z0-9]+\.)+[A-z]{2,4}$/;
    var vResult = document.getElementById('validateEmailResult');
    var vRules =  document.getElementById('validateEmailRules');
    if(!inputField.value.match(regExpression))
    {
        validationUnCorrect(vResult, vRules);
        return false;
    }
    else
    {
        validationCorrect(vResult, vRules);
        return true;
    }
}

function validateCountry(inputField)
{
    var regExpression = /^[a-zA-Z-]+$/;
    var vResult = document.getElementById('validateCountryResult');
    var vRules =  document.getElementById('validateCountryRules');
    if(!inputField.value.match(regExpression))
    {
        validationUnCorrect(vResult, vRules);
        return false;
    }
    else
    {
        validationCorrect(vResult, vRules);
        return true;
    }
}

function validateCity(inputField)
{
    var regExpression = /^[a-zA-Z-]+$/;
    var vResult = document.getElementById('validateCityResult');
    var vRules =  document.getElementById('validateCityRules');
    if(!inputField.value.match(regExpression))
    {
        validationUnCorrect(vResult, vRules);
        return false;
    }
    else
    {
        validationCorrect(vResult, vRules);
        return true;
    }
}


function validatePassword(inputField)
{
    var regExpression = /(?=^.{8,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$/;
    var vResult = document.getElementById('validatePasswordResult');
    var vRules =  document.getElementById('validatePasswordRules');
    if(!inputField.value.match(regExpression))
    {
        validationUnCorrect(vResult, vRules);
        return false;
    }
    else
    {
        validationCorrect(vResult, vRules);
        return true;
    }
}

function validatePasswordConfirmation(inputFieldPass, inputFieldPassConf)
{
    var vResult = document.getElementById('validatePasswordConfResult');
    var vRules =  document.getElementById('validatePasswordConfRules');
    if(inputFieldPass.value == inputFieldPassConf.value)
    {
        validationCorrect(vResult, vRules);
        return true;
    }
    else if(inputFieldPass.value != inputFieldPassConf.value)
    {
        validationUnCorrect(vResult, vRules);
        return false;
    }
    else{}
}

function validateForm(form)
{
    if(validateLogin(2, 25, form["name"]) &&
       validateEmail(form["email"]) &&
       validateCountry(form["country"]) &&
       validateCity(form["city"]) &&
       validatePassword(form["password"]) &&
       validatePasswordConfirmation(form["password"], form["confirm"]))
    {
        form.submit();
        return true;
    }
    else
    {
        //document.getElementById('user_submit').style.cssText =
        //"color:#ffffff;" +
        //"background:#cd2626;" +
        //"background: -moz-linear-gradient(top, #cd2626 0%, #ff3030 50%, #ff0000 100%);" +
        //"background: -webkit-linear-gradient(top, #cd2626 0%, #ff3030 50%, #ff0000 100%);" +
        //"background: -o-linear-gradient(top, #cd2626 0%, #ff3030 50%, #ff0000 100%);" +
        //"background: -ms-linear-gradient(top, #cd2626 0%, #ff3030 50%, #ff0000 100%);" +
        //"background: linear-gradient(top, #cd2626 0%, #ff3030 50%, #ff0000 100%);";
        return false;
    }
}

/*if(validateLogin(2, 25, form['user_login'], form['validateLoginResult'], form['validateLoginRules']) &&
validateEmail(form['user_email'], form['validateEmailResult'], form['validateEmailRules']) &&
validateCountry(form['user_country'], form['validateCountryResult'], form['validateCountryRules']) &&
validateCity(form['user_city'], form['validateCityResult'], form['validateCityRules']) &&
validatePassword(form['user_password'], form['validatePasswordResult'], form['validatePasswordRules']) &&
validatePasswordConfirmation(form['user_password'], form['user_password_conf'], form['validatePasswordConfResult'], form['validatePasswordConfRules']))*/

/*function testValidator(form)
 {
 if(document.getElementById('validateLoginRules').style.color == '#008000' &&
 document.getElementById('validateEmailRules').style.color == '#008000' &&
 document.getElementById('validateCountryRules').style.color == '#008000' &&
 document.getElementById('validateCityRules').style.color == '#008000' &&
 document.getElementById('validatePasswordRules').style.color == '#008000' &&
 document.getElementById('validatePasswordConfRules').style.color == '#008000')
 {
 form.submit();
 }
 else
 {
 alert("FATAL ERROR!!!");
 }
 }*/