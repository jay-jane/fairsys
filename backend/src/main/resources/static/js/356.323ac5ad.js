"use strict";(self["webpackChunkfrontend"]=self["webpackChunkfrontend"]||[]).push([[356],{8356:function(e,t,i){i.r(t),i.d(t,{default:function(){return P}});var l=i(6252);const a=(0,l._)("h3",{style:{"text-align":"center"}},"채용 공고 등록 페이지",-1),s=(0,l.uE)('<div id="field"><label class="field_name">제목</label><div id=""><input type="text"></div></div><div id="field"><label class="field_name">담당자 성함</label><div id=""><input type="text"></div></div><div id="field"><label class="field_name">기업명</label><div id=""><input type="text"></div></div><div class="field tel-number"><label class="field_name">휴대폰 번호</label><div class="tel_number_input"><input type="text" id="tel_number_1"> - <input type="text" id="tel_number_2"> - <input type="text" id="tel_number_3"></div></div><div id="field"><label class="field_name">이메일 주소</label><div id=""><input type="text"></div></div><div id="field"><label class="field_name">업종</label><div id="job_type"></div></div>',6),n={id:"field"},d=(0,l._)("label",{class:"field_name"},"모집 분야",-1),r={id:"job_type"},o=(0,l._)("div",{id:"recruit_type"},[(0,l._)("input",{type:"text",class:"recruit_type_input"}),(0,l._)("input",{type:"text",style:{width:"40px","margin-left":"5px"}}),(0,l._)("span",null,"명 모집")],-1),p=(0,l.uE)('<div id="field"><label class="field_name">경력 여부</label><div id="career" style="display:inline-block;"><input type="radio" name="career_type">신입 <input type="radio" name="career_type">경력 <input type="radio" name="career_type">경력무관 </div></div><div id="field"><label class="field_name">대표 근무지역</label><div class="kakaoAPI">(카카오맵api)</div></div><div id="field"><label class="field_name">연봉/급여</label><div id="sal_wrap"><select id="sal_type"><option value="sal_y">연봉</option><option value="sal_m">월급</option></select><select id="sal_y"><option value="sal_y">2,200 ~ 2,800</option><option value="sal_y">2,800 ~ 3,200</option><option value="sal_y">3,200 ~ 3,600</option><option value="sal_y">3,600 ~ 4,000</option></select><input type="hidden" class="sal_m"><button type="button" class="sal_m" style="display:hidden;">입력</button></div></div><div id="field"><label class="field_name">근무 형태</label><div style="display:inline-block;"><input type="radio" name="work_type" value="정규직">정규직 <input type="radio" name="work_type" value="계약직">계약직 <input type="radio" name="work_type" value="인턴">인턴 </div></div><div id="field"><label class="field_name">상세 내용</label><div class="content">나중에@@@@</div></div>',5),u={id:"field"},c=(0,l._)("label",{class:"field_name"},"전형 절차",-1),v={id:""},_=(0,l._)("div",{id:"process_wrap"},[(0,l._)("input",{type:"text",id:"process",value:"서류전형",readonly:""})],-1),h={id:"process_wrap"},f=(0,l._)("input",{type:"text",id:"process",value:"1차면접",readonly:""},null,-1),g={id:"process_wrap"},y=(0,l._)("input",{type:"text",id:"process",value:"2차면접",readonly:""},null,-1),m=(0,l._)("div",{id:"process_wrap"},[(0,l._)("input",{type:"text",id:"process",value:"최종합격",readonly:""})],-1),b=(0,l._)("div",{id:"field endDate"},[(0,l._)("label",{class:"field_name"},"마감일자"),(0,l._)("div",null,"(달력api)")],-1),w=(0,l._)("input",{type:"submit",value:"등록"},null,-1);function k(e,t,i,k,x,M){const I=(0,l.up)("Hashtags");return(0,l.wg)(),(0,l.iD)("section",null,[a,(0,l._)("form",{onSubmit:t[3]||(t[3]=(...t)=>e.regist&&e.regist(...t))},[s,(0,l._)("div",n,[d,(0,l._)("div",r,[(0,l.Wm)(I)]),o]),p,(0,l._)("div",u,[c,(0,l._)("div",v,[_,(0,l._)("div",h,[f,(0,l._)("img",{class:"deleteBtn",onClick:t[0]||(t[0]=(...t)=>e.deleteItem&&e.deleteItem(...t)),src:"https://picsum.photos/20/20",alt:"삭제"})]),(0,l._)("div",g,[y,(0,l._)("img",{class:"deleteBtn",onClick:t[1]||(t[1]=(...t)=>e.deleteItem&&e.deleteItem(...t)),src:"https://picsum.photos/20/20",alt:"삭제"})]),m])]),b,(0,l._)("div",null,[w,(0,l._)("input",{type:"button",value:"취소",onClick:t[2]||(t[2]=(...e)=>M.goMain&&M.goMain(...e))})])],32)])}var x=i(3577),M=i(9963);const I={key:0,class:"help"},T={key:1,class:"tags"},D=["onClick"],H={class:"inp"},C={key:0,class:"noti"};function E(e,t,i,a,s,n){return(0,l.wg)(),(0,l.iD)("div",{class:"comp_hashtag",onClick:t[8]||(t[8]=(...e)=>n.setHashtags&&n.setHashtags(...e)),ref:"group"},[s.helpVisible?((0,l.wg)(),(0,l.iD)("p",I,(0,x.zw)(s.defaultPlaceholder),1)):(0,l.kq)("",!0),s.helpVisible?(0,l.kq)("",!0):((0,l.wg)(),(0,l.iD)("div",T,[(0,l._)("input",{type:"text",class:"fake",ref:"fake",onKeydown:[t[0]||(t[0]=(0,M.D2)((0,M.iM)((e=>n.deleteTag(s.focusIndex)),["prevent"]),["backspace"])),t[1]||(t[1]=(0,M.D2)((0,M.iM)((e=>n.deleteTag(s.focusIndex)),["prevent"]),["delete"]))]},null,544),((0,l.wg)(!0),(0,l.iD)(l.HY,null,(0,l.Ko)(s.tags,((e,t)=>((0,l.wg)(),(0,l.iD)("span",{class:(0,x.C_)(["tag",{active:e.select}]),key:t,onClick:e=>n.selectTag(t)},(0,x.zw)(e.value),11,D)))),128))])),(0,l.wy)((0,l._)("div",H,[(0,l.wy)((0,l._)("input",{type:"text",ref:"input","onUpdate:modelValue":t[2]||(t[2]=e=>s.value=e),onFocus:t[3]||(t[3]=(...e)=>n.initSelect&&n.initSelect(...e)),onKeydown:[t[4]||(t[4]=(0,M.D2)((0,M.iM)(((...e)=>n.addHashTags&&n.addHashTags(...e)),["prevent"]),["space"])),t[5]||(t[5]=(0,M.D2)((0,M.iM)(((...e)=>n.addHashTags&&n.addHashTags(...e)),["prevent"]),["enter"])),t[6]||(t[6]=(0,M.D2)(((...e)=>n.initErrorMsg&&n.initErrorMsg(...e)),["backspace"])),t[7]||(t[7]=(0,M.D2)(((...e)=>n.initErrorMsg&&n.initErrorMsg(...e)),["delete"]))],placeholder:"태그입력"},null,544),[[M.nr,s.value,void 0,{trim:!0}]])],512),[[M.F8,!s.helpVisible]]),(0,l.Wm)(M.uT,{"enter-active-class":"animate__animated animate__fadeInDown animate__faster","leave-active-class":"animate__animated animate__fadeOut"},{default:(0,l.w5)((()=>[this.errorMsg?((0,l.wg)(),(0,l.iD)("p",C,(0,x.zw)(s.errorMsg),1)):(0,l.kq)("",!0)])),_:1})],512)}i(7658);var S={name:"Hashtags",props:["placeholder"],data(){return{defaultPlaceholder:this.placeholder?this.placeholder:"#추천태그 #특수문자제외",errorMsg:null,focusIndex:null,helpVisible:!0,tags:[],value:""}},methods:{setVisible(){return this.helpVisible=!1},async setHashtags(){if(this.tags.length>0)return;const e=await this.setVisible();e||this.$refs.input.focus()},addTag(){return this.tags.push({value:this.value,select:!1}),!0},unselectTag(){this.tags.forEach((e=>e.select=!1))},selectTag(e){this.tags.some((e=>e.select))&&this.unselectTag(),this.tags[e].select=!this.tags[e].select,this.tags[e].select?(this.$refs.fake.focus(),this.focusIndex=e):this.initSelectIndex()},deleteTag(e){null!==e&&(this.initSelectIndex(),this.tags.splice(e,1))},initSelect(){this.tags.some((e=>e.select))&&(this.unselectTag(),this.initSelectIndex())},initSelectIndex(){this.focusIndex=null},initErrorMsg(){this.errorMsg=null},validate(){if(this.tags.some((e=>e.value===this.value)))return"중복된 단어를 입력하셨습니다.";const e=/[~!@#$%^&*()+|<>?:{},.="':;/-]/;return!!e.test(this.value)&&"특수문자는 태그로 등록할 수 없습니다."},async addHashTags(e){if(""===e.target.value)return this.initErrorMsg(),void e.target.focus();const t=await this.validate();if(t)return this.errorMsg=t,void this.$refs.input.focus();await this.addTag(),this.errorMsg=null,this.value=null,this.$refs.input.focus()}},mounted(){}},V=i(3744);const $=(0,V.Z)(S,[["render",E],["__scopeId","data-v-a7ee7d10"]]);var q=$,z={name:"App",methods:{goMain:()=>{location.href="/"}},components:{Hashtags:q}};const K=(0,V.Z)(z,[["render",k]]);var P=K}}]);
//# sourceMappingURL=356.323ac5ad.js.map