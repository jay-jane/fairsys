"use strict";(self["webpackChunkfrontend"]=self["webpackChunkfrontend"]||[]).push([[130],{130:function(e,s,l){l.r(s),l.d(s,{default:function(){return Q}});var t=l(6252),i=l(9963),r=l(3577);const a={action:""},u={class:"cont_division"},d={style:{display:["flex"],flexDirection:["row"],justifyContent:["space-between"]}},n={style:{borderBottom:["4px solid #777"]}},o=(0,t._)("br",null,null,-1),_=(0,t._)("br",null,null,-1),p=(0,t._)("label",{for:"user_id"},"아이디 ",-1),c=(0,t._)("label",{for:"user_pw"},"비밀번호 ",-1),h={key:0,style:{color:["red"]}},w={key:1,style:{color:["green"]}},y=(0,t._)("label",{for:"user_pw_re"},"비밀번호 확인 ",-1),g={key:0,style:{color:["red"]}},m={key:1,style:{color:["green"]}},k={for:"user_name"},v=(0,t._)("label",{for:"user_birth"},"생년월일 ",-1),b=(0,t._)("option",{value:""},"년",-1),f=["value"],x=(0,t._)("option",{value:""},"월",-1),D=["value"],V=(0,t._)("option",{value:""},"일",-1),L=["value"],C=(0,t._)("label",{for:"user_gender"},"성별",-1),U=(0,t._)("option",{value:""},"성별",-1),F=["value"],A=(0,t._)("label",{for:"user_phone"},"전화번호 ",-1),z=(0,t._)("label",{for:"user_email"},"이메일 ",-1),$=(0,t._)("label",{for:"address"},"주소 ",-1),P=(0,t._)("br",null,null,-1),q=(0,t._)("br",null,null,-1),R={class:"cont_division"},I=(0,t._)("span",{class:"terms_agree"},[(0,t._)("strong",null,"약관")],-1),Y={class:"agree_box"},Z={class:"agree_article"},K={class:"inpChk sizeL"},S=(0,t._)("label",{class:"check_all check_off lbl",for:"agreeAllPersonal"},[(0,t._)("strong",null,"전체동의")],-1),H={class:"agree_article depth2"},M={class:"agree_desc"},N={class:"chk"},j=["id","value"],T=["for"],W=(0,t._)("a",{href:""},[(0,t._)("br")],-1),B={class:"list"};function E(e,s,l,E,G,J){const O=(0,t.up)("router-link");return(0,t.wg)(),(0,t.iD)("form",a,[(0,t._)("section",null,[(0,t._)("div",u,[(0,t._)("div",d,[(0,t._)("h3",n,[(0,t.Wm)(O,{to:"/3-1"},{default:(0,t.w5)((()=>[(0,t.Uk)("개인 회원가입")])),_:1})]),(0,t._)("h3",null,[(0,t.Wm)(O,{to:"/3-2"},{default:(0,t.w5)((()=>[(0,t.Uk)("기업 회원가입")])),_:1})])]),o,_,(0,t._)("div",null,[p,(0,t.wy)((0,t._)("input",{"onUpdate:modelValue":s[0]||(s[0]=e=>G.user_id=e),onKeydown:s[1]||(s[1]=(0,i.D2)(((...s)=>e.sameIdCheck&&e.sameIdCheck(...s)),["enter"])),required:"",type:"text",placeholder:"아이디"},null,544),[[i.nr,G.user_id]]),(0,t._)("button",{type:"button",onClick:s[2]||(s[2]=(...e)=>J.checkId&&J.checkId(...e)),style:{width:["60px"],fontSize:["8px"],textAlign:["center"],padding:["1px"]}},"중복확인")]),(0,t._)("div",null,[c,(0,t.wy)((0,t._)("input",{"onUpdate:modelValue":s[3]||(s[3]=e=>G.user_pw=e),required:"",type:"password",placeholder:"비밀번호"},null,512),[[i.nr,G.user_pw]]),G.passwordValidFlag||""===this.user_pw?(0,t.kq)("",!0):((0,t.wg)(),(0,t.iD)("span",h,"유효하지 않은 비밀번호 입니다.")),G.passwordValidFlag&&""!==this.user_pw?((0,t.wg)(),(0,t.iD)("span",w,"유효한 비밀번호 입니다.")):(0,t.kq)("",!0)]),(0,t._)("div",null,[y,(0,t.wy)((0,t._)("input",{"onUpdate:modelValue":s[4]||(s[4]=e=>G.user_pw_re=e),required:"",type:"password",placeholder:"비밀번호 재확인"},null,512),[[i.nr,G.user_pw_re]]),G.passwordCheckFlag||""===this.user_pw_re?(0,t.kq)("",!0):((0,t.wg)(),(0,t.iD)("span",g,"비밀번호가 다릅니다.")),G.passwordCheckFlag&&""!==this.user_pw_re?((0,t.wg)(),(0,t.iD)("span",m,"비밀번호가 일치합니다.")):(0,t.kq)("",!0)]),(0,t._)("div",null,[(0,t._)("label",k,[(0,t.Uk)("이름 "),(0,t.wy)((0,t._)("input",{"onUpdate:modelValue":s[5]||(s[5]=e=>G.user_name=e),required:"",type:"text",placeholder:"성함"},null,512),[[i.nr,G.user_name]])])]),v,(0,t._)("div",null,[(0,t.wy)((0,t._)("select",{id:"yyyy",class:"sel","onUpdate:modelValue":s[6]||(s[6]=e=>G.signup.yyyy=e),style:{width:["100px"],textAlignLast:["center"]}},[b,((0,t.wg)(!0),(0,t.iD)(t.HY,null,(0,t.Ko)(G.yyyyList,((e,s)=>((0,t.wg)(),(0,t.iD)("option",{key:s,value:e.value},(0,r.zw)(e.text),9,f)))),128))],512),[[i.bM,G.signup.yyyy]]),(0,t.wy)((0,t._)("select",{id:"mm",class:"sel","onUpdate:modelValue":s[7]||(s[7]=e=>G.signup.mm=e),style:{width:["100px"],textAlignLast:["center"]}},[x,((0,t.wg)(!0),(0,t.iD)(t.HY,null,(0,t.Ko)(G.mmlist,((e,s)=>((0,t.wg)(),(0,t.iD)("option",{key:s,value:e.value},(0,r.zw)(e.text),9,D)))),128))],512),[[i.bM,G.signup.mm]]),(0,t.wy)((0,t._)("select",{id:"dd",class:"sel","onUpdate:modelValue":s[8]||(s[8]=e=>G.signup.dd=e),style:{width:["100px"],textAlignLast:["center"]}},[V,((0,t.wg)(!0),(0,t.iD)(t.HY,null,(0,t.Ko)(G.ddlist,((e,s)=>((0,t.wg)(),(0,t.iD)("option",{key:s,value:e.value},(0,r.zw)(e.text),9,L)))),128))],512),[[i.bM,G.signup.dd]])]),C,(0,t._)("div",null,[(0,t.wy)((0,t._)("select",{class:"sel","onUpdate:modelValue":s[9]||(s[9]=e=>G.user_gender=e),style:{width:["100px"],textAlignLast:["center"]}},[U,((0,t.wg)(!0),(0,t.iD)(t.HY,null,(0,t.Ko)(G.genderList,((e,s)=>((0,t.wg)(),(0,t.iD)("option",{key:s,value:e.value},(0,r.zw)(e.text),9,F)))),128))],512),[[i.bM,G.user_gender]])]),(0,t._)("div",null,[A,(0,t.wy)((0,t._)("input",{"onUpdate:modelValue":s[10]||(s[10]=e=>G.user_phone=e),required:"",type:"text",placeholder:"전화번호를 입력하세요",maxlength:"11"},null,512),[[i.nr,G.user_phone]])]),(0,t._)("div",null,[z,(0,t.wy)((0,t._)("input",{"onUpdate:modelValue":s[11]||(s[11]=e=>G.user_email=e),required:"",type:"email",placeholder:"이메일"},null,512),[[i.nr,G.user_email]])]),(0,t._)("div",null,[$,(0,t.wy)((0,t._)("input",{type:"text","onUpdate:modelValue":s[12]||(s[12]=e=>G.user_postcode=e),placeholder:"우편번호"},null,512),[[i.nr,G.user_postcode]]),(0,t._)("input",{type:"button",onClick:s[13]||(s[13]=e=>J.execDaumPostcode()),value:"우편번호 찾기"}),P,(0,t.wy)((0,t._)("input",{type:"text","onUpdate:modelValue":s[14]||(s[14]=e=>G.user_address=e),placeholder:"주소"},null,512),[[i.nr,G.user_address]]),q,(0,t.wy)((0,t._)("input",{type:"text","onUpdate:modelValue":s[15]||(s[15]=e=>G.user_detail_address=e),placeholder:"상세주소"},null,512),[[i.nr,G.user_detail_address]])]),(0,t._)("div",R,[I,(0,t._)("div",Y,[(0,t._)("ul",Z,[(0,t._)("li",null,[(0,t._)("span",K,[(0,t.wy)((0,t._)("input",{type:"checkbox",id:"agreeAllPersonal",class:"check_mail","onUpdate:modelValue":s[16]||(s[16]=e=>J.allSelected=e)},null,512),[[i.e8,J.allSelected]]),S])])]),((0,t.wg)(!0),(0,t.iD)(t.HY,null,(0,t.Ko)(G.checkList,((e,l)=>((0,t.wg)(),(0,t.iD)("div",{key:l},[(0,t._)("ul",H,[(0,t._)("li",null,[(0,t._)("div",M,[(0,t._)("span",N,[(0,t.wy)((0,t._)("input",{type:"checkbox",id:e,value:e,"onUpdate:modelValue":s[17]||(s[17]=e=>G.selectList=e)},null,8,j),[[i.e8,G.selectList]]),(0,t._)("label",{for:e},[(0,t._)("span",null,[(0,t._)("strong",null,(0,r.zw)(e),1)])],8,T)])]),W])])])))),128))])])]),(0,t._)("div",B,[(0,t._)("button",{type:"button",onClick:s[18]||(s[18]=(...e)=>J.submitForm&&J.submitForm(...e))},"가입하기"),(0,t._)("button",{class:"view",onClick:s[19]||(s[19]=(...e)=>J.btn_view&&J.btn_view(...e))},"목록")])])])}l(7658);var G={data(){return{user_id:"",user_pw:"",user_pw_re:"",user_name:"",user_birth:"",user_gender:"",user_postcode:"",user_address:"",user_detail_address:"",detailAddress:"",user_email:"",user_phone:"",checkList:["(필수)개인회원 약관에 동의","(필수)개인정보 수집 및 이용에 동의","(선택)위치기반서비스 이용약관에 동의","(선택)마케팅 정보 수신 동의 -이메일","(선택)마케팅 정보 수신 동의"],selectList:[],idPassCheck:!1,phCertifPassCheck:!1,nameRule:/^[가-힣a-zA-Z]+$/,idRule:/^[a-z0-9]{4,12}$/,passwordRule:/^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,20}$/,emailRule:/([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/,phoneNumRule:/^[0-9]{8,13}$/,passwordValidFlag:!0,passwordCheckFlag:!0,checkFlag:!1,signup:{yyyy:"2023",mm:"03",dd:"14"},genderList:[{value:"M",text:"남성"},{value:"F",text:"여성"}],yyyyList:[],mmlist:[],ddlist:[]}},methods:{checkId(){""!==this.user_id?!1===this.idRule.test(this.user_id.trim())?alert("아이디는 4~12글자 이내로 영어 대소문자,숫자만 가능합니다"):this.axios.post("/3-1/checkId",{user_id:this.user_id}).then((e=>{console.log(e),e.data?this.msg="사용이 가능한 id 입니다":this.msg="이미 사용하고 있는 id 입니다",alert(this.msg)})).catch((e=>{console.log(e)})):this.msg="Id를 입력해주세요"},checkPw(){/^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,20}$/.test(this.user_pw)?this.passwordValidFlag=!0:this.passwordValidFlag=!1},checkPwRe(){this.user_pw===this.user_pw_re?this.passwordCheckFlag=!0:this.passwordCheckFlag=!1},checkEmail(){},async submitForm(){console.log(1),this.axios.post("/3-1/registForm",{user_id:this.user_id,user_pw:this.user_pw,user_name:this.user_name,user_email:this.user_email,user_birth:this.signup.yyyy+""+this.signup.mm+this.signup.dd,user_gender:this.user_gender,user_phone:this.user_phone,user_postcode:this.user_postcode,user_address:this.user_address,user_detail_address:this.user_detail_address}).then((e=>{console.log(e),console.log(e.config.data),this.$router.push({path:"/"})})).catch((e=>{console.log(e)}))},btn_view(){location.href="page1"},execDaumPostcode(){new window.daum.Postcode({oncomplete:e=>{""!==this.user_detail_address&&(this.user_detail_address=""),"R"===e.userSelectedType?this.user_address=e.roadAddress:this.user_address=e.jibunAddress,"R"===e.userSelectedType?(""!==e.bname&&/[동|로|가]$/g.test(e.bname)&&(this.user_detail_address+=e.bname),""!==e.buildingName&&"Y"===e.apartment&&(this.user_detail_address+=""!==this.user_detail_address?`, ${e.buildingName}`:e.buildingName),""!==this.user_detail_address&&(this.user_detail_address=`(${this.user_detail_address})`)):this.user_detail_address="",this.user_postcode=e.zonecode}}).open()}},computed:{allSelected:{get:function(){return this.checkList.length===this.selectList.length},set:function(e){this.selectList=e?this.checkList:[]}}},watch:{user_pw:function(){this.checkPw()},user_pw_re:function(){this.checkPwRe()}},created(){const e=(new Date).getFullYear();for(let s=0;s<100;s++){let l=e-s;this.yyyyList.push({value:l,text:l})}for(let s=1;s<13;s++)s<10?this.mmlist.push({value:"0"+s,text:"0"+s}):this.mmlist.push({value:s,text:s});for(let s=1;s<=31;s++)s<10?this.ddlist.push({value:"0"+s,text:"0"+s}):this.ddlist.push({value:s,text:s})}},J=l(3744);const O=(0,J.Z)(G,[["render",E]]);var Q=O}}]);
//# sourceMappingURL=130.4c124f87.js.map