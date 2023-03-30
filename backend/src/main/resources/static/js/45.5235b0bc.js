"use strict";(self["webpackChunkfrontend"]=self["webpackChunkfrontend"]||[]).push([[45],{3045:function(e,l,o){o.r(l),o.d(l,{default:function(){return K}});var t=o(6252),a=o(9963),s=o(3577);const c={action:""},d={class:"cont_division"},n={style:{display:["flex"],flexDirection:["row"],justifyContent:["space-between"]}},i={style:{borderBottom:["4px solid orange"]}},_=(0,t._)("br",null,null,-1),r=(0,t._)("br",null,null,-1),m=(0,t._)("label",{for:"com_id"},"아이디 ",-1),u=(0,t._)("label",{for:"com_pw"},"비밀번호 ",-1),p={key:0,style:{color:["red"]}},h={key:1,style:{color:["green"]}},w=(0,t._)("label",{for:"com_pw_re"},"비밀번호 확인 ",-1),g={key:0,style:{color:["red"]}},y={key:1,style:{color:["green"]}},b=(0,t._)("label",{for:"com_num"},"사업자등록번호 ",-1),k=(0,t._)("label",{for:"com_name"},"회사명 ",-1),f=(0,t._)("label",{for:"com_category"},"회사분류 ",-1),v=(0,t._)("label",{for:"com_ceo"},"대표자명 ",-1),x=(0,t._)("label",{for:"address"},"주소 ",-1),V=(0,t._)("br",null,null,-1),U=(0,t._)("br",null,null,-1),q=(0,t._)("label",{for:"com_manager"},"담당자명 ",-1),F=(0,t._)("label",{for:"com_manager_phone"},"전화번호 ",-1),C=(0,t._)("label",{for:"com_email"},"이메일 ",-1),$={class:"cont_division"},z=(0,t._)("span",{class:"terms_agree"},[(0,t._)("strong",null,"약관")],-1),A={class:"agree_box"},D={class:"agree_article"},L={class:"inpChk sizeL"},P=(0,t._)("label",{class:"check_all check_off lbl",for:"agreeAllPersonal"},[(0,t._)("strong",null,"전체동의")],-1),R={class:"agree_article depth2"},S={class:"agree_desc"},Z={class:"chk"},I=["id","value"],N=["for"],j=(0,t._)("a",{href:""},[(0,t._)("br")],-1),T={class:"list"};function W(e,l,o,W,Y,B){const H=(0,t.up)("router-link");return(0,t.wg)(),(0,t.iD)("form",c,[(0,t._)("section",null,[(0,t._)("div",d,[(0,t._)("div",n,[(0,t._)("h3",null,[(0,t.Wm)(H,{to:"/3-1"},{default:(0,t.w5)((()=>[(0,t.Uk)("개인 회원가입")])),_:1})]),(0,t._)("h3",i,[(0,t.Wm)(H,{to:"/3-2"},{default:(0,t.w5)((()=>[(0,t.Uk)("기업 회원가입")])),_:1})])]),_,r,(0,t._)("div",null,[m,(0,t.wy)((0,t._)("input",{"onUpdate:modelValue":l[0]||(l[0]=e=>Y.com_id=e),required:"",type:"text",placeholder:"아이디"},null,512),[[a.nr,Y.com_id]]),(0,t._)("button",{type:"button",onClick:l[1]||(l[1]=(...e)=>B.checkId&&B.checkId(...e)),style:{width:["60px"],fontSize:["8px"],textAlign:["center"],padding:["1px"]}},"중복확인")]),(0,t._)("div",null,[u,(0,t.wy)((0,t._)("input",{"onUpdate:modelValue":l[2]||(l[2]=e=>Y.com_pw=e),required:"",type:"password",placeholder:"비밀번호"},null,512),[[a.nr,Y.com_pw]]),Y.passwordValidFlag||""===this.com_pw?(0,t.kq)("",!0):((0,t.wg)(),(0,t.iD)("span",p,"유효하지 않은 비밀번호 입니다.")),Y.passwordValidFlag&&""!==this.com_pw?((0,t.wg)(),(0,t.iD)("span",h,"유효한 비밀번호 입니다.")):(0,t.kq)("",!0)]),(0,t._)("div",null,[w,(0,t.wy)((0,t._)("input",{"onUpdate:modelValue":l[3]||(l[3]=e=>Y.com_pw_re=e),required:"",type:"password",placeholder:"비밀번호 재확인"},null,512),[[a.nr,Y.com_pw_re]]),Y.passwordCheckFlag||""===this.com_pw_re?(0,t.kq)("",!0):((0,t.wg)(),(0,t.iD)("span",g,"비밀번호가 다릅니다.")),Y.passwordCheckFlag&&""!==this.com_pw_re?((0,t.wg)(),(0,t.iD)("span",y,"비밀번호가 일치합니다.")):(0,t.kq)("",!0)]),(0,t._)("div",null,[b,(0,t.wy)((0,t._)("input",{"onUpdate:modelValue":l[4]||(l[4]=e=>Y.com_num=e),required:"",type:"text",placeholder:"사업자 번호"},null,512),[[a.nr,Y.com_num]])]),(0,t._)("div",null,[k,(0,t.wy)((0,t._)("input",{"onUpdate:modelValue":l[5]||(l[5]=e=>Y.com_name=e),required:"",type:"text",placeholder:"회사이름"},null,512),[[a.nr,Y.com_name]])]),(0,t._)("div",null,[f,(0,t.wy)((0,t._)("input",{"onUpdate:modelValue":l[6]||(l[6]=e=>Y.com_category=e),required:"",type:"text",placeholder:"회사분류"},null,512),[[a.nr,Y.com_category]])]),(0,t._)("div",null,[v,(0,t.wy)((0,t._)("input",{"onUpdate:modelValue":l[7]||(l[7]=e=>Y.com_ceo=e),required:"",type:"text",placeholder:"대표자명"},null,512),[[a.nr,Y.com_ceo]])]),(0,t._)("div",null,[x,(0,t.wy)((0,t._)("input",{type:"text","onUpdate:modelValue":l[8]||(l[8]=e=>Y.com_postcode=e),placeholder:"우편번호"},null,512),[[a.nr,Y.com_postcode]]),(0,t._)("input",{type:"button",onClick:l[9]||(l[9]=e=>B.execDaumPostcode()),value:"우편번호 찾기"}),V,(0,t.wy)((0,t._)("input",{type:"text","onUpdate:modelValue":l[10]||(l[10]=e=>Y.com_address=e),placeholder:"주소"},null,512),[[a.nr,Y.com_address]]),U,(0,t.wy)((0,t._)("input",{type:"text","onUpdate:modelValue":l[11]||(l[11]=e=>Y.com_detail_address=e),placeholder:"상세주소"},null,512),[[a.nr,Y.com_detail_address]])]),(0,t._)("div",null,[q,(0,t.wy)((0,t._)("input",{"onUpdate:modelValue":l[12]||(l[12]=e=>Y.com_manager=e),required:"",type:"text",placeholder:"담당자"},null,512),[[a.nr,Y.com_manager]])]),(0,t._)("div",null,[F,(0,t.wy)((0,t._)("input",{"onUpdate:modelValue":l[13]||(l[13]=e=>Y.com_manager_phone=e),required:"",type:"text",placeholder:"전화번호"},null,512),[[a.nr,Y.com_manager_phone]])]),(0,t._)("div",null,[C,(0,t.wy)((0,t._)("input",{"onUpdate:modelValue":l[14]||(l[14]=e=>Y.com_email=e),required:"",type:"email",placeholder:"이메일"},null,512),[[a.nr,Y.com_email]])]),(0,t._)("div",$,[z,(0,t._)("div",A,[(0,t._)("ul",D,[(0,t._)("li",null,[(0,t._)("span",L,[(0,t.wy)((0,t._)("input",{type:"checkbox",id:"agreeAllPersonal",class:"check_mail","onUpdate:modelValue":l[15]||(l[15]=e=>B.allSelected=e)},null,512),[[a.e8,B.allSelected]]),P])])]),((0,t.wg)(!0),(0,t.iD)(t.HY,null,(0,t.Ko)(Y.checkList,((e,o)=>((0,t.wg)(),(0,t.iD)("div",{key:o},[(0,t._)("ul",R,[(0,t._)("li",null,[(0,t._)("div",S,[(0,t._)("span",Z,[(0,t.wy)((0,t._)("input",{type:"checkbox",id:e,value:e,"onUpdate:modelValue":l[16]||(l[16]=e=>Y.selectList=e)},null,8,I),[[a.e8,Y.selectList]]),(0,t._)("label",{for:e},[(0,t._)("span",null,[(0,t._)("strong",null,(0,s.zw)(e),1)])],8,N)])]),j])])])))),128))])]),(0,t._)("div",T,[(0,t._)("button",{type:"button",onClick:l[17]||(l[17]=(...e)=>B.submitForm&&B.submitForm(...e))},"가입하기"),(0,t._)("button",{class:"view",onClick:l[18]||(l[18]=(...e)=>B.btn_view&&B.btn_view(...e))},"목록")])])])])}o(7658);var Y={data(){return{com_id:"",com_pw:"",com_pw_re:"",com_num:"",com_name:"",com_category:"",com_ceo:"",com_postcode:"",com_address:"",com_detail_address:"",com_manager:"",com_manager_phone:"",com_email:"",msg:"",checkList:["(필수)개인회원 약관에 동의","(필수)개인정보 수집 및 이용에 동의","(선택)위치기반서비스 이용약관에 동의","(선택)마케팅 정보 수신 동의 -이메일","(선택)마케팅 정보 수신 동의"],selectList:[],passwordValidFlag:!0,passwordCheckFlag:!0,idRule:/^[a-z0-9]{4,12}$/,passwordRule:/^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,20}$/,emailRule:/([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/,phoneNumRule:/^[0-9]{8,13}$/}},methods:{btn_view(){location.href="page1"},checkId(){""!==this.user_id?!1===this.idRule.test(this.com_id.trim())?alert("아이디는 4~12글자 이내로 영어 대소문자,숫자만 가능합니다"):this.axios.post("/3-2/checkId",{user_id:this.com_id}).then((e=>{console.log(e),e.data?this.msg="사용이 가능한 id 입니다":this.msg="이미 사용하고 있는 id 입니다",alert(this.msg)})).catch((e=>{console.log(e)})):this.msg="Id를 입력해주세요"},checkPw(){/^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,20}$/.test(this.com_pw)?this.passwordValidFlag=!0:this.passwordValidFlag=!1},checkPwRe(){this.com_pw===this.com_pw_re?this.passwordCheckFlag=!0:this.passwordCheckFlag=!1},async submitForm(){console.log(1),this.axios.post("/3-2/registForm",{com_id:this.com_id,com_pw:this.com_pw,com_num:this.com_num,com_name:this.com_name,com_category:this.com_category,com_ceo:this.com_ceo,com_postcode:this.com_postcode,com_address:this.com_address,com_detail_address:this.com_detail_address,com_manager:this.com_manager,com_manager_phone:this.com_manager_phone,com_email:this.com_email}).then((e=>{console.log(e),console.log(e.config.data),this.$router.push({path:"/"})})).catch((e=>{console.log(e)}))},execDaumPostcode(){new window.daum.Postcode({oncomplete:e=>{""!==this.com_detail_address&&(this.com_detail_address=""),"R"===e.userSelectedType?this.com_address=e.roadAddress:this.com_address=e.jibunAddress,"R"===e.userSelectedType?(""!==e.bname&&/[동|로|가]$/g.test(e.bname)&&(this.com_detail_address+=e.bname),""!==e.buildingName&&"Y"===e.apartment&&(this.user_detail_address+=""!==this.user_detail_address?`, ${e.buildingName}`:e.buildingName),""!==this.com_detail_address&&(this.com_detail_address=`(${this.com_detail_address})`)):this.com_detail_address="",this.com_postcode=e.zonecode}}).open()}},computed:{allSelected:{get:function(){return this.checkList.length===this.selectList.length},set:function(e){this.selectList=e?this.checkList:[]}}},watch:{com_pw:function(){this.checkPw()},com_pw_re:function(){this.checkPwRe()}}},B=o(3744);const H=(0,B.Z)(Y,[["render",W]]);var K=H}}]);
//# sourceMappingURL=45.5235b0bc.js.map