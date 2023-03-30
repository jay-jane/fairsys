"use strict";(self["webpackChunkfrontend"]=self["webpackChunkfrontend"]||[]).push([[437],{5590:function(e,t,i){i.d(t,{Z:function(){return v}});var l=i(6252),a=i(3577),s=i(9963);const n=e=>((0,l.dD)("data-v-02d90079"),e=e(),(0,l.Cn)(),e),_={key:0,class:"help"},r={key:1,class:"tags"},o=["onClick"],u=n((()=>(0,l._)("button",{type:"button",style:{border:"0","font-size":"15px",cursor:"pointer",color:"orangered"}},"x",-1))),d={class:"inp"},c=n((()=>(0,l._)("datalist",{id:"options"},[(0,l._)("option",{value:"UI/UX 디자이너"}),(0,l._)("option",{value:"웹 개발(JAVA)"}),(0,l._)("option",{value:"일반사무"})],-1))),h={key:0,class:"noti"};function j(e,t,i,n,j,p){return(0,l.wg)(),(0,l.iD)("div",{class:"comp_hashtag",onClick:t[8]||(t[8]=(...e)=>p.setHashtags&&p.setHashtags(...e)),ref:"group"},[j.helpVisible?((0,l.wg)(),(0,l.iD)("p",_,(0,a.zw)(j.defaultPlaceholder),1)):(0,l.kq)("",!0),j.helpVisible?(0,l.kq)("",!0):((0,l.wg)(),(0,l.iD)("div",r,[(0,l._)("input",{type:"text",class:"fake",ref:"fake",onKeydown:[t[0]||(t[0]=(0,s.D2)((0,s.iM)((e=>p.deleteTag(j.focusIndex)),["prevent"]),["backspace"])),t[1]||(t[1]=(0,s.D2)((0,s.iM)((e=>p.deleteTag(j.focusIndex)),["prevent"]),["delete"]))]},null,544),((0,l.wg)(!0),(0,l.iD)(l.HY,null,(0,l.Ko)(j.tags,((e,t)=>((0,l.wg)(),(0,l.iD)("span",{class:(0,a.C_)(["tag",{active:e.select}]),key:t,onClick:e=>(p.selectTag(t),p.deleteTag(t))},[(0,l.Uk)((0,a.zw)(e.value)+" ",1),u],10,o)))),128))])),(0,l.wy)((0,l._)("div",d,[(0,l.wy)((0,l._)("input",{type:"text",list:"options",ref:"input","onUpdate:modelValue":t[2]||(t[2]=e=>j.value=e),onFocus:t[3]||(t[3]=(...e)=>p.initSelect&&p.initSelect(...e)),onKeydown:[t[4]||(t[4]=(0,s.D2)((0,s.iM)(((...e)=>p.addHashTags&&p.addHashTags(...e)),["prevent"]),["space"])),t[5]||(t[5]=(0,s.D2)((0,s.iM)(((...e)=>p.addHashTags&&p.addHashTags(...e)),["prevent"]),["enter"])),t[6]||(t[6]=(0,s.D2)(((...e)=>p.initErrorMsg&&p.initErrorMsg(...e)),["backspace"])),t[7]||(t[7]=(0,s.D2)(((...e)=>p.initErrorMsg&&p.initErrorMsg(...e)),["delete"]))],placeholder:"태그입력"},null,544),[[s.nr,j.value,void 0,{trim:!0}]]),c],512),[[s.F8,!j.helpVisible]]),(0,l.Wm)(s.uT,{"enter-active-class":"animate__animated animate__fadeInDown animate__faster","leave-active-class":"animate__animated animate__fadeOut"},{default:(0,l.w5)((()=>[this.errorMsg?((0,l.wg)(),(0,l.iD)("p",h,(0,a.zw)(j.errorMsg),1)):(0,l.kq)("",!0)])),_:1})],512)}i(7658);var p={name:"Hashtags",props:["placeholder"],data(){return{defaultPlaceholder:this.placeholder?this.placeholder:"#특수문자제외",errorMsg:null,focusIndex:null,helpVisible:!0,tags:[],value:"",valList:[]}},methods:{setVisible(){return this.helpVisible=!1},async setHashtags(){if(this.tags.length>0)return;const e=await this.setVisible();e||this.$refs.input.focus()},addTag(){return this.tags.push({value:this.value,select:!1}),!0},unselectTag(){this.tags.forEach((e=>e.select=!1))},selectTag(e){this.tags.some((e=>e.select))&&this.unselectTag(),this.tags[e].select=!this.tags[e].select,this.tags[e].select?(this.$refs.fake.focus(),this.focusIndex=e):this.initSelectIndex()},deleteTag(e){null!==e&&(this.initSelectIndex(),this.tags.splice(e,1),this.valList.splice(e,1),this.$router.push({path:"/registJobPosting/"+sessionStorage.getItem("com_id"),query:{valList:this.valList}}))},initSelect(){this.tags.some((e=>e.select))&&(this.unselectTag(),this.initSelectIndex())},initSelectIndex(){this.focusIndex=null},initErrorMsg(){this.errorMsg=null},validate(){if(this.tags.some((e=>e.value===this.value)))return"중복된 단어를 입력하셨습니다.";const e=/[~!@#$%^&*+|<>?:{},.="':;-]/;return e.test(this.value)?"특수문자는 태그로 등록할 수 없습니다.":"UI/UX 디자이너"!==this.value&&"웹 개발(JAVA)"!==this.value&&"일반사무"!==this.value?"선택할 수 없는 분야입니다.":(this.valList.includes(this.value)||this.valList.push(this.value),!1)},async addHashTags(e){if(""===e.target.value)return this.initErrorMsg(),void e.target.focus();const t=await this.validate();if(t)return this.errorMsg=t,void this.$refs.input.focus();await this.addTag(),this.errorMsg=null,this.value=null,this.$refs.input.focus(),this.$router.push({path:"/registJobPosting/"+sessionStorage.getItem("com_id"),query:{valList:this.valList}})}}},y=i(3744);const g=(0,y.Z)(p,[["render",j],["__scopeId","data-v-02d90079"]]);var v=g},8437:function(e,t,i){i.r(t),i.d(t,{default:function(){return ce}});var l=i(6252),a=i(9963);const s={id:"jy_main_wrap"},n=(0,l._)("h3",{style:{"text-align":"center"}},"채용 공고 수정",-1),_={id:"jy_field"},r=(0,l._)("label",{class:"jy_field_name"},"제목",-1),o={id:""},u=["value"],d={id:"jy_field"},c=(0,l._)("label",{class:"jy_field_name"},"담당자 성함",-1),h={id:""},j=["value"],p={id:"jy_field"},y=(0,l._)("label",{class:"jy_field_name"},"기업명",-1),g={id:""},v=["value"],m={class:"jy_field tel-number"},f=(0,l._)("label",{class:"jy_field_name"},"휴대폰 번호",-1),b={class:"jy_tel_number_input"},x=["value"],w={id:"jy_field"},k=(0,l._)("label",{class:"jy_field_name"},"이메일 주소",-1),D={id:""},T=["value"],M={id:"jy_field"},C=(0,l._)("label",{class:"jy_field_name"},"모집 분야",-1),I={id:"jy_job_type"},V=["value"],$={id:"jy_recruit_type",style:{display:"inline-block"}},H=["value"],A=(0,l._)("span",null,"명 모집",-1),E={id:"jy_field"},N=(0,l._)("label",{class:"jy_field_name"},"경력 여부",-1),P={id:"jy_career"},S=["value"],F={id:"jy_field"},L=(0,l._)("label",{class:"jy_field_name"},"근무지역",-1),U={class:"jy_kakaoAPI"},J=["value"],O={id:"jy_field"},q=(0,l._)("label",{class:"jy_field_name"},"급여(연봉)",-1),z={id:"jy_sal_wrap"},K=["value"],Z={id:"jy_field"},R=(0,l._)("label",{class:"jy_field_name"},"근무 형태",-1),X=["value"],Y={id:"jy_field"},W=(0,l._)("label",{class:"jy_field_name"},"학력",-1),B=(0,l._)("br",null,null,-1),G=["value"],Q={id:"jy_field"},ee=(0,l._)("label",{class:"jy_field_name"},"상세 내용",-1),te=["value"],ie={id:"jy_field"},le=(0,l._)("label",{class:"jy_field_name"},"전형 절차",-1),ae={id:""},se=["value"],ne={id:"jy_modi-btn-wrap"};function _e(e,t,i,_e,re,oe){return(0,l.wg)(),(0,l.iD)("section",null,[((0,l.wg)(!0),(0,l.iD)(l.HY,null,(0,l.Ko)(re.list,(e=>((0,l.wg)(),(0,l.iD)("div",s,[n,(0,l._)("div",_,[r,(0,l._)("div",o,[(0,l.wy)((0,l._)("input",{type:"hidden","onUpdate:modelValue":t[0]||(t[0]=e=>re.com_id=e)},null,512),[[a.nr,re.com_id]]),(0,l._)("input",{type:"text",class:"jy_text",value:e.j_title,onChange:t[1]||(t[1]=(...e)=>oe.getTitle&&oe.getTitle(...e))},null,40,u)])]),(0,l._)("div",d,[c,(0,l._)("div",h,[(0,l._)("input",{type:"text",class:"jy_text jy_f",value:e.companyVO.com_manager,readonly:""},null,8,j)])]),(0,l._)("div",p,[y,(0,l._)("div",g,[(0,l._)("input",{type:"text",class:"jy_text jy_f",value:e.companyVO.com_name,readonly:""},null,8,v)])]),(0,l._)("div",m,[f,(0,l._)("div",b,[(0,l._)("input",{type:"text",class:"jy_text jy_f",id:"jy_tel_number",value:e.companyVO.com_manager_phone,readonly:""},null,8,x)])]),(0,l._)("div",w,[k,(0,l._)("div",D,[(0,l._)("input",{type:"email",class:"jy_text",value:e.j_email,onChange:t[2]||(t[2]=(...e)=>oe.getEmail&&oe.getEmail(...e))},null,40,T)])]),(0,l._)("div",M,[C,(0,l._)("div",I,[(0,l._)("input",{type:"text",class:"jy_text jy_f",value:e.j_department,readonly:""},null,8,V)]),(0,l._)("div",$,[(0,l._)("input",{type:"text",class:"jy_text",style:{width:"40px","margin-left":"5px"},value:e.j_recruitNum,onChange:t[3]||(t[3]=(...e)=>oe.getRecruitNum&&oe.getRecruitNum(...e))},null,40,H),A])]),(0,l._)("div",E,[N,(0,l._)("div",P,[(0,l._)("input",{type:"text",class:"jy_text jy_f",value:e.j_career,readonly:""},null,8,S)])]),(0,l._)("div",F,[L,(0,l._)("div",U,[(0,l._)("input",{type:"text",class:"jy_text jy_f",value:e.j_address+e.j_detail_address,readonly:""},null,8,J)])]),(0,l._)("div",O,[q,(0,l._)("div",z,[(0,l._)("input",{type:"text",class:"jy_text jy_f",value:e.j_salary,readonly:""},null,8,K)])]),(0,l._)("div",Z,[R,(0,l._)("div",null,[(0,l._)("input",{type:"text",class:"jy_text jy_f",value:e.j_type,readonly:""},null,8,X)])]),(0,l._)("div",Y,[W,B,(0,l._)("input",{type:"text",class:"jy_text jy_f",value:e.j_graduation,readonly:""},null,8,G)]),(0,l._)("div",Q,[ee,(0,l._)("textarea",{id:"jy_field",class:"jy_textarea",cols:"70",rows:"20",value:e.j_content,onChange:t[4]||(t[4]=(...e)=>oe.getContent&&oe.getContent(...e))},null,40,te)]),(0,l._)("div",ie,[le,(0,l._)("div",ae,[(0,l._)("input",{type:"text",class:"jy_text jy_f",value:"서류심사 > "+e.j_schedule+"합격",readonly:""},null,8,se)])]),(0,l._)("div",ne,[(0,l._)("button",{type:"button",class:"modi_btn",value:"등록",onClick:t[5]||(t[5]=(...e)=>oe.updateForm&&oe.updateForm(...e)),style:{"margin-right":"10px"}},"수정 완료"),(0,l._)("button",{type:"button",class:"modi_btn",value:"삭제",onClick:t[6]||(t[6]=(...e)=>oe.deleteForm&&oe.deleteForm(...e)),style:{"margin-right":"10px"}},"삭제"),(0,l._)("button",{type:"button",class:"modi_btn",value:"취소",onClick:t[7]||(t[7]=(...e)=>oe.goMain&&oe.goMain(...e))},"취소")])])))),256))])}i(7658);var re=i(5590),oe={name:"App",data(){return{j_no:0,j_recruitNum:"",j_email:"",j_title:"",j_content:"",j_salary:"",j_department:"",j_schedule:"",j_graduation:"",j_career:"",j_type:"",com_id:"1818",list:[],j_end_date:""}},methods:{goMain(){this.$router.push("/4")},updateForm(){this.axios.post("/jobPostingUpdate",{j_no:this.$route.params.j_no,j_recruitNum:this.j_recruitNum,j_email:this.j_email,j_title:this.j_title,j_content:this.j_content,j_salary:this.j_salary,j_department:this.j_department,j_schedule:this.j_schedule,j_graduation:this.j_graduation,j_career:this.j_career,j_type:this.j_type}).then((()=>{this.j_no=this.$route.params.j_no,alert("수정되었습니다."),this.$router.push("/jobPostingDetail/"+this.j_no)})).catch((e=>{console.log(e)}))},deleteForm(){confirm("삭제하시겠습니까?")&&this.axios.post("/jobPostingDelete",{j_no:this.$route.params.j_no}).then((()=>{alert("삭제되었습니다"),this.$router.push("/4")})).catch((e=>console.log(e)))},getJobDetail(){this.j_no=this.$route.params.j_no,this.axios.get("/jobPostingDetail/"+this.j_no,{params:{j_no:this.j_no}}).then((e=>{this.list=e.data,this.j_schedule=this.list[0].j_schedule,this.list[0].j_department=this.list[0].j_department.replaceAll("[","").replaceAll("]","").replaceAll('"',"").replaceAll(","," / "),this.getOriginal()})).catch((e=>{console.log(e)}))},getOriginal(){this.j_title=this.list[0].j_title,this.j_email=this.list[0].j_email,this.j_recruitNum=this.list[0].j_recruitNum,this.j_content=this.list[0].j_content},getTitle(e){this.j_title=e.target.value},getEmail(e){this.j_email=e.target.value},getRecruitNum(e){this.j_recruitNum=e.target.value},getContent(e){this.j_content=e.target.value}},mounted(){this.getJobDetail()},components:{Hashtags:re.Z}},ue=i(3744);const de=(0,ue.Z)(oe,[["render",_e]]);var ce=de}}]);
//# sourceMappingURL=437.2578656d.js.map