/**
 * 鏌ヨ鐢ㄦ埛鎿嶄綔Js鎻掍欢
 * @example
 * 浣跨敤demo:<input type="text" name='' value='' onclick="core.searchUser.init($(this),showUser)">
 * @author jason <yangjs@yeah.net>
 * @version TS3.0
 */
core.searchUser = {
    /**
     * 缁欏伐鍘傝皟鐢ㄧ殑鎺ュ彛
     * @param array attrs 閰嶇疆鏁扮粍
     * @return void
     * @private
     */
    _init: function(attrs) {
        if(attrs.length == 1) {
            return false;
        }
        if(attrs.length == 6) {
            core.searchUser.init(attrs[1],attrs[2],attrs[3],attrs[4],attrs[5]);
        } else if(attrs.length == 5) {
            core.searchUser.init(attrs[1],attrs[2],attrs[3],attrs[4]);
        } else if(attrs.length == 4) {
            core.searchUser.init(attrs[1],attrs[2],attrs[3]);
        } else if(attrs.length == 3) {
            core.searchUser.init(attrs[1],attrs[2]);
        } else {
            core.searchUser.init(attrs[1]);
        }
    },
    /**
     * 鎻掍欢鍒濆鍖�
     * @param object input 鏌ヨ瀵硅薄鍩�
     * @param integer follow 鏌ヨ绫诲瀷锛屽叏绔欐垨鍏虫敞鐨勪汉
     * @param integer max 鏈€澶ф煡璇汉鏁�
     * @param function callback 鍥炶皟鍑芥暟
     * @param integer noself 鏄惁鎺掗櫎鑷繁
     * @return void
     */
    init: function(input, follow, max, callback, noself) {
        this.notuser = '',					// 涓婃鏌ヨ鐨勬棤缁撴灉鐢ㄦ埛
            this.olduser = '',					// 涓婃鏌ヨ鐨勭敤鎴峰悕
            this.searchTime = 0, 				// 褰撳墠鎼滅储鐢ㄦ埛璁板綍鐨勬鏁�
            this.input = input,					// 鏌ヨ鐨勫璞″煙
            this.userserintval = '', 			// 鏌ヨ鐢ㄦ埛鐨勮疆璇�
            this.userList = '';					// 鐢ㄦ埛鍒楄〃鏄剧ず瀵硅薄
        this.follow = "undefined" == typeof(follow) ? 1 : follow;
        this.max = "undefined" == typeof(max) ? 0: max;
        this.noself = "undefined" == typeof(noself) ? 1: noself;
        this.stoploop = 0;
        if("undefined" != typeof(callback)) {
            this.callback = callback;
        } else {
            this.callback = '';
        }
        var _this = this;
        // 缁戝畾绂诲紑浜嬩欢
        this.input.blur(function() {
            var hide = function() {
                _this._stopUser();
                _this._removeUserList();
            };
            setTimeout(hide, 150);
        });
        // 绉婚櫎鐢ㄦ埛鍒楄〃
        this._removeUserList();
        // 鍚姩鐢ㄦ埛鏌ヨ
        this._startUser();
    },
    /**
     * 鎻掑叆鐢ㄦ埛鏁版嵁
     * @param integer uid 鐢ㄦ埛ID
     * @param string uname 鐢ㄦ埛鏄电О
     * @param string email 鐢ㄦ埛Email
     * @return void
     */
    insertUser: function(uid, uname) {
        if(uid == '0') {
            return false;
        }
        var oArgs = M.getEventArgs(this.input[0]);
        if("undefined" == typeof(this.input.prev())) {
            $('<input type="hidden" value="' + oArgs.uid + '" name="' + oArgs.name + '" id="search_uids" rel="uids">').insertBefore(this.input);
        } else {
            if(this.input.prev().attr('rel') != 'uids') {
                $('<input type="hidden" value="' + oArgs.uid + '" name="' + oArgs.name + '" id="search_uids" rel = "uids">').insertBefore(this.input);
            }
        }
        var uidsInput = this.input.prev();
        if(uidsInput.prev().attr('rel') != "userlist") {
            $('<ul class="user-list" rel = "userlist" ></ul>').insertBefore(uidsInput);
        }
        var dllist = uidsInput.prev();
        var uids = uidsInput.val();
        var regExp = new RegExp( "^" + uid + "$|^" + uid + ",|," + uid );
        if(uids.match(regExp)) {
            ui.error('姝ょ敤鎴峰凡缁忓瓨鍦�');
            return false;
        } else {
            var init = 1;
            if(this.max > 0) {
                if(uids != '') {
                    var _uids = uids.split(',');
                    if(_uids.length >= this.max) {
                        ui.error('鍙兘閫夋嫨'+this.max+'涓敤鎴�');
                        return false;
                    }
                    if(_uids.length+1 >= this.max) {
                        this.input.blur();
                        this.input.hide();
                        init = 0;
                    }
                } else {
                    if(this.max == 1) {
                        this.input.blur();
                        this.input.hide();
                        init = 0;
                    }
                }
            }
            var html = '<li><a class="ico-close right" href="javascript:;" onclick ="core.searchUser.removeUser('+uid+',this)"></a>\
						   <div class="content"><a href="javascript:;">'+uname+'</a></div></li>';//<span>('+email+')</span>
            dllist.append(html);
            if(uids!='' && uids !='0') {
                uidsInput.val(uids + "," +uid);
            } else {
                uidsInput.val(uid);
            }
            this.input.val('');
            this.inputReset(1);
            return true;
        }
    },
    inputReset:function(init){
        this.olduser = '';
        this._stopUser();
        this._removeUserList();
        this.stoploop = 0;
        if(init == 1){
            this.init(this.input,this.follow,this.max,this.callback,this.noself);
        }
    },
    selectUser:function(){
        var curUser = this.userList.find('.mod-at-list').find('.current');
        if(curUser.length>0){
            //閫変汉鍚�
            var uid = curUser.attr('uid');
            var uname = curUser.attr('uname');
            var email = curUser.attr('email');
            core.searchUser.insertUser(uid,uname,email);
        }else{
            return true;
        }
        return true;
    },
    /**
     * 绉婚櫎宸查€変腑鐨勭敤鎴�
     * @param integer uid 绉婚櫎鐢ㄦ埛ID
     * @param object obj 浜嬩欢瑙﹀彂瀵硅薄
     * @return void
     */
    removeUser: function(uid, obj)
    {
        // 鑾峰彇闅愯棌琛ㄥ崟鐨勫€�
        var hideInput = null;
        $(obj).parent().parent().parent().find('input').each(function(){
            if($(this).attr('rel') == 'uids'){
                hideInput = $(this);
            }
        });
        // 绉婚櫎LI
        $(obj).parent().remove();
        // 璁剧疆鏂扮殑琛ㄥ崟瀵硅薄
        if(hideInput == null){
            hideInput = this.input.prev();
        }
        // 鑾峰彇琛ㄥ崟瀵硅薄鍊�
        var uids = hideInput.val();
        var arr = uids.split(',');
        var val = new Array();
        for(var i in arr) {
            if(arr[i] != uid && arr[i] != '' && "string" == typeof(arr[i])) {
                val.push(arr[i]);
            }
        }
        hideInput.val(val.join(','));
        this.input.show();
        this._removeUserList();
    },
    _startUser:function(){
        var _this = this;
        var loopSearchUser = function(){

            if(_this.stoploop == 1){
                return true;
            }

            var searchUser = function(searchTime,user){
                $.post(U('widget/SearchUser/search'),{key:user,follow:_this.follow,noself:_this.noself},function(msg){
                    if(searchTime != _this.searchTime){	// 瓒呮椂浜�
                        return false;
                    }
                    if(msg.status==0 || msg.data == null || msg.data =='' || msg.data.length == 0 ){
                        _this.notuser = user;
                        _this.userList.find('.mod-at-list').html("<div class='mod-at-tips'>娌℃湁鏌ユ壘鍒扮浉鍏崇敤鎴�</div>");
                        return false;
                    }else{
                        if("function" == typeof(_this.callback)){
                            _this.callback(msg.data);
                            return false;
                        }
                        var data = msg.data;
                        _this.notuser ='';
                        if(data.length > 0){ //鍒楄〃
                            var html = '<ul class="at-user-list">';
                            for(var i in data){
                                var current = i==0 ? " class='current'" : '';
                                html +='<li onclick ="core.searchUser.insertUser('+data[i].uid+',\''+data[i].uname+'\')"' //,\''+data[i].email+'\'
                                    +' uid ="'+data[i].uid+'" uname="'+data[i].uname+'"'+current+'>'//	email="'+data[i].email+'"
                                    +'<div class="face"><img src="'+data[i].avatar_small+'" width="20px" height="20px" /></div>'
                                    +'<div class="content"><a href="javascript:void(0)">'+data[i].uname+'</a><span></span></div></li>';//<span>'+data[i].email+'</span>
                            }
                            html +='</ul>';
                            _this.userList.find('.mod-at-list').html(html);
                            _this.userList.find('.mod-at-list').find('li').hover(function(){
                                $(this).addClass('hover')
                            },function(){
                                $(this).removeClass('hover');
                            });
                            //TODO 鏂瑰悜閿帶鍒�
                            core.plugInit('bindkey',$(_this.userList.find('.mod-at-list')),'li','current','core.searchUser.selectUser()');
                        }else{	//鐩存帴娣诲姞
                            core.searchUser.insertUser(data.uid,data.uname);//,data.email
                            _this._removeUserList();
                            //_this.input.parent().find('.mod-at-wrap').remove();
                        }
                    }
                },'json');
            };

            var user = _this.input.val();

            if(user == ''){  //閲嶅缓鏄剧ず涓嬫媺妗�

                _this.olduser = '';
                //_this.input.parent().find('.mod-at-wrap').remove();
                //_this._removeUserList();
                core.searchUser._createUserlistDiv();
            }else{
                if((_this.notuser!='' && user.indexOf(_this.notuser) >= 0) || _this.olduser == user){
                    //涓嶆煡鎵剧敤鎴蜂簡
                }else{
                    _this.olduser = user;
                    _this.searchTime ++;
                    core.searchUser._createUserlistDiv();
                    searchUser(_this.searchTime,user);
                }
            }
        }
        this.userserintval = setInterval(loopSearchUser,250);
    },
    _stopUser:function(){
        this.stoploop = 1;
        if(this.userserintval != ''){
            //鍋滄杞鏌ユ壘
            clearInterval(this.userserintval);
            this.userserintval='';
        }
        this._removeUserList();
        //this.input.parent().find('.mod-at-wrap').remove();
    },
    _createUserlistDiv:function(){

        if(typeof(this.userList)!='string'){
            return false;
        }

        var html = "<div class='mod-at-wrap' style='z-index:10000000;position:absolute;' id='message_box'><div class='mod-at'><div class='mod-at-list'>"
            +"<div class='mod-at-tips'>璇疯緭鍏ユ煡鎵剧殑浜烘樀绉般€侀偖绠便€佹墜鏈哄彿</div>"
            +"</div></div></div>";
        this.userList = $(html);
        this.userList.appendTo('body');
        var _this = this;
        this._showUserList();
    },
    _showUserList:function(){
        var  x = this.input.offset();
        if(this.input[0].style.display == 'none'){
            this.userList.css({'left':x.left+'px','top':(x.top+this.input.height()+14)+'px','width':this.input.width()+10+'px','display':'none'});
        }else{
            this.userList.css({'left':x.left+'px','top':(x.top+this.input.height()+14)+'px','width':this.input.width()+10+'px','display':'block'});
        }
    },
    _removeUserList:function(){
        if($('#message_box').length >0 ){
            $('#message_box').remove();
        }

        if(this.userList.length > 0 && "string" != typeof(this.userList)){
            this.userList.remove();
        }
        this.userList  = '';
    }
};