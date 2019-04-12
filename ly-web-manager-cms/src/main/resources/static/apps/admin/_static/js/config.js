
//绔欑偣閰嶇疆椤甸潰JS
admin.siteConfigDefault = function(value){
    $("input[name='mzLevelSelect4']").hide();
    var html ='<input type="submit" value="纭畾" onclick="return confirm(\'鍏抽棴绔欑偣鍚庣綉绔欏皢鏃犳硶璁块棶锛岀‘瀹氳鍏抽棴鍚楋紵\')"'
        +' id ="form_submit_2" class="btn_b">';
    $(html).insertAfter($('#form_submit')).hide();
    admin.siteConfig(value);
};

admin.siteConfig = function(value){

    $('.form2 dl').each(function(){
        var _id = $(this).attr('id');
        if(_id != "dl_site_closed"){
            if(value == "1"){
                if(_id != "dl_site_closed_reason"){
                    $(this).show();
                }else{
                    $(this).hide();
                }
            }else{
                if(_id == "dl_site_closed_reason"){
                    $(this).show();
                }else{
                    $(this).hide();
                }
            }
        }
    });
    if(value==1){
        $('#form_submit').show();$('#form_submit_2').hide();
    }else{
        $('#form_submit_2').show();$('#form_submit').hide();
    }
};

//鍏抽棴搴旂敤
admin.setAppStatus = function(app_id,status){
    if(app_id ==''){
        var app_id = admin.getChecked();
    }
    if(app_id == ''){
        ui.error( "璇烽€夋嫨瑕佸叧闂殑搴旂敤" );
        return false;
    }
    $.post(U('admin/Apps/setAppStatus'),{app_id:app_id,status:status},function(msg){
        admin.ajaxReload(msg);
    },'json');
};

admin.testEmail = function(){
    var email_sendtype = $('#form_email_sendtype').val();
    var email_host = $('#form_email_host').val();
    var email_port = $('#form_email_port').val();
    var email_ssl = $('input:radio[name="email_ssl"]:checked').val();
    var email_account = $('#form_email_account').val();
    var email_password = $('#form_email_password').val();
    var email_sender_name = $('#form_email_sender_name').val();
    var email_sender_email = $('#form_email_sender_email').val();
    var sendto_email = $('#form_email_test').val();
    if ( sendto_email == ''){
        ui.error('娴嬭瘯閭欢鍦板潃鏈～');
        return;
    }
    var eMailReg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((.[a-zA-Z0-9_-]{2,3}){1,2})$/;
    if(!eMailReg.test(sendto_email)) {
        ui.error("閭鏍煎紡涓嶆纭�");
        return false;
    }
    $.post(U('admin/Public/test_email'),
        {email_sendtype:email_sendtype,email_host:email_host,email_port:email_port,email_ssl:email_ssl,email_account:email_account,
            email_password:email_password,email_sender_name:email_sender_name,sendto_email:sendto_email,email_sender_email:email_sender_email},
        function(msg){
            if(msg == 1 ){
                ui.success("鍙戦€佹垚鍔�");
            }else{
                alert(msg);
            }
        });
};
