// 娣诲姞鐢ㄦ埛楠岃瘉淇℃伅
admin.addUserSubmitCheck = function(form) {
    if (getLength(form.password.value) < 1) {
        ui.error('瀵嗙爜涓嶈兘涓虹┖');
        return false;
    }
    if (!admin.checkUser(form)) {
        return false;
    }
    // if ($('input[name="user_group[]"]:checked').length < 1) {
    //     ui.error('璇烽€夋嫨鐢ㄦ埛缁�');
    //     return false;
    // }
    return true;
};
// 妫€楠岀敤鎴峰熀鏈俊鎭�
admin.checkUser = function(form) {
    if (getLength(form.uname.value) < 1) {
        ui.error('鏄电О涓嶈兘涓虹┖');
        return false;
    }
    return true;
};
// 绂佺敤鐢ㄦ埛
admin.delUser = function(id) {
    if ("undefined" == typeof(id) || id == '') id = admin.getChecked();
    if (id == '') {
        ui.error('璇烽€夋嫨瑕佺鐢ㄧ殑鐢ㄦ埛');
        return false;
    }
    var dodel = '绂佺敤';
    $.post(U('basic/Message/doPost'), {
        to: id,
        dodel: dodel,
        content: "111"
    }, function(msg) {}, 'json');
    ui.confirm('纭畾瑕佺鐢ㄩ€変腑鐢ㄦ埛锛�', {
        yes: function() {
            $.post(U('admin/User/doDeleteUser'), {
                id: id
            }, function(msg) {
                admin.ajaxReload(msg);
            }, 'json');
        }
    });
};
// 褰诲簳鍒犻櫎鐢ㄦ埛
admin.trueDelUser = function(id) {
    if ("undefined" == typeof(id) || id == '') id = admin.getChecked();
    if (id == '') {
        ui.error('璇烽€夋嫨瑕佸垹闄ょ殑鐢ㄦ埛');
        return false;
    }
    ui.confirm('纭畾瑕佸交搴曞垹闄ら€変腑鐢ㄦ埛锛�', {
        yes: function() {
            $.post(U('admin/User/doTrueDeleteUser'), {
                id: id
            }, function(msg) {
                admin.ajaxReload(msg);
            }, 'json');
        }
    });
};
// 鎭㈠鐢ㄦ埛
admin.rebackUser = function(id) {
    if ("undefined" == typeof(id) || id == '') id = admin.getChecked();
    if (id == '') {
        ui.error('璇烽€夋嫨瑕佹仮澶嶇殑鐢ㄦ埛');
        return false;
    }
    ui.confirm('纭畾瑕佹仮澶嶉€変腑鐢ㄦ埛锛�', {
        yes: function() {
            $.post(U('admin/User/doRebackUser'), {
                id: id
            }, function(msg) {
                admin.ajaxReload(msg);
            }, 'json');
        }
    });
};
//杞Щ鐢ㄦ埛缁�
admin.changeUserGroup = function() {
    var id = admin.getChecked();
    if (id == '') {
        ui.error('璇烽€夋嫨鐢ㄦ埛');
        return false;
    }
    var url = U('admin/User/moveGroup') + '&uid=' + id;
    //ui.tbox("load('"+url+"','杞Щ鐢ㄦ埛缁�')");
    ui.box.load(url, '杞Щ鐢ㄦ埛缁�');
};
//瀵煎嚭鐢ㄦ埛
admin.exportUser = function() {
    var id = admin.getChecked();
    if (id == '') {
        ui.error('璇烽€夋嫨鐢ㄦ埛');
        return false;
    }
    location.href = U('admin/User/exportUser') + '&uid=' + id;
};
admin.domoveUsergroup = function() {
    var ids = new Array();
    $.each($('#movegroup input:checked'), function(i, n) {
        if ($(n).val() != '0' && $(n).val() != '') {
            ids.push($(n).val());
        }
    });
    if (ids.length < 1) {
        ui.error('璇烽€夋嫨鐢ㄦ埛缁�');
        return false;
    }
    ids = ids.join(',');
    var uid = $('#uid').val();
    $.post(U('admin/User/domoveUsergroup'), {
        uid: uid,
        user_group_id: ids
    }, function(msg) {
        admin.ajaxReload(msg);
    }, 'json');
};

//澶勭悊瀛︿範璁板綍
admin.mzLearnEdit = function(_id, action, title, type) {
    var id = ("undefined" == typeof(_id) || _id == '') ? admin.getChecked() : _id;
    if (id == '') {
        ui.error('璇烽€夋嫨瑕�' + title + '鐨�' + type);
        return false;
    }
    ui.confirm('纭畾瑕�' + title + '閫変腑鐨�' + type + '锛�', {
        yes: function() {
            $.post(U('course/AdminVideo/' + action), {
                id: id
            }, function(msg) {
                admin.ajaxReload(msg);
            }, 'json');
        }
    });
};