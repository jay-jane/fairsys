"use strict";(self["webpackChunkfrontend"]=self["webpackChunkfrontend"]||[]).push([[55],{55:function(e,l,n){n.r(l),n.d(l,{default:function(){return g}});var d=n(252),r=n(963);const o={action:""},t=(0,d._)("h3",null,"기업회원가입",-1),a={for:"com_name"},s=(0,d._)("label",{for:"com_ceo"},"대표자명: ",-1),u=(0,d._)("label",{for:"business_number"},"사업자등록번호: ",-1),i=(0,d._)("br",null,null,-1),m=(0,d._)("br",null,null,-1),_=(0,d._)("label",{for:"com_userid"},"id: ",-1),c=(0,d._)("label",{for:"com_password"},"password: ",-1),p=(0,d._)("label",{for:"com_number"},"전화번호: ",-1),b=(0,d._)("label",{for:"com_manager"},"가입자명: ",-1),h=(0,d._)("label",{for:"com_email"},"이메일: ",-1),w={class:"list"},y=(0,d._)("h4",null,"푸터",-1);function x(e,l,n,x,f,v){return(0,d.wg)(),(0,d.iD)("form",o,[(0,d._)("section",null,[t,(0,d._)("div",null,[(0,d._)("label",a,[(0,d.Uk)("회사명: "),(0,d.wy)((0,d._)("input",{"onUpdate:modelValue":l[0]||(l[0]=e=>f.com_name=e),required:"",type:"text",placeholder:"회사이름을 입력하세요"},null,512),[[r.nr,f.com_name]])])]),(0,d._)("div",null,[s,(0,d.wy)((0,d._)("input",{"onUpdate:modelValue":l[1]||(l[1]=e=>f.com_ceo=e),required:"",type:"text",placeholder:"대표자명을 입력하세요"},null,512),[[r.nr,f.com_ceo]])]),(0,d._)("div",null,[u,(0,d.wy)((0,d._)("input",{"onUpdate:modelValue":l[2]||(l[2]=e=>f.business_number=e),required:"",type:"number",placeholder:"사업자 번호를 입력하세요"},null,512),[[r.nr,f.business_number]])]),(0,d._)("div",null,[(0,d.wy)((0,d._)("input",{type:"text","onUpdate:modelValue":l[3]||(l[3]=e=>f.postcode=e),placeholder:"우편번호"},null,512),[[r.nr,f.postcode]]),(0,d._)("input",{type:"button",onClick:l[4]||(l[4]=e=>v.execDaumPostcode()),value:"우편번호 찾기"}),i,(0,d.wy)((0,d._)("input",{type:"text","onUpdate:modelValue":l[5]||(l[5]=e=>f.address=e),placeholder:"주소"},null,512),[[r.nr,f.address]]),m,(0,d.wy)((0,d._)("input",{type:"text","onUpdate:modelValue":l[6]||(l[6]=l=>e.detailAddress=l),placeholder:"상세주소"},null,512),[[r.nr,e.detailAddress]])]),(0,d._)("div",null,[_,(0,d.wy)((0,d._)("input",{"onUpdate:modelValue":l[7]||(l[7]=e=>f.com_userid=e),required:"",type:"text",placeholder:"아이디를 입력하세요"},null,512),[[r.nr,f.com_userid]])]),(0,d._)("div",null,[c,(0,d.wy)((0,d._)("input",{"onUpdate:modelValue":l[8]||(l[8]=e=>f.com_password=e),required:"",type:"password",placeholder:"비밀번호를 입력하세요"},null,512),[[r.nr,f.com_password]])]),(0,d._)("div",null,[p,(0,d.wy)((0,d._)("input",{"onUpdate:modelValue":l[9]||(l[9]=e=>f.com_number=e),required:"",type:"number",placeholder:"전화번호를 입력하세요"},null,512),[[r.nr,f.com_number]])]),(0,d._)("div",null,[b,(0,d.wy)((0,d._)("input",{"onUpdate:modelValue":l[10]||(l[10]=e=>f.com_manager=e),required:"",type:"text",placeholder:"성함을 입력하세요"},null,512),[[r.nr,f.com_manager]])]),(0,d._)("div",null,[h,(0,d.wy)((0,d._)("input",{"onUpdate:modelValue":l[11]||(l[11]=e=>f.com_email=e),required:"",type:"email"},null,512),[[r.nr,f.com_email]])]),(0,d._)("div",w,[(0,d._)("button",{type:"submit",onClick:l[12]||(l[12]=(...l)=>e.page30&&e.page30(...l))},"가입하기"),(0,d._)("button",{class:"view",onClick:l[13]||(l[13]=(...e)=>v.btn_view&&v.btn_view(...e))},"목록")])]),y])}var f={data(){return{com_name:"",com_ceo:"",business_number:"",postcode:"",address:"",extraAddress:"",com_userid:"",com_password:"",com_number:"",com_manager:"",com_email:""}},methods:{btn_view(){location.href="page1"},execDaumPostcode(){new window.daum.Postcode({oncomplete:e=>{""!==this.extraAddress&&(this.extraAddress=""),"R"===e.userSelectedType?this.address=e.roadAddress:this.address=e.jibunAddress,"R"===e.userSelectedType?(""!==e.bname&&/[동|로|가]$/g.test(e.bname)&&(this.extraAddress+=e.bname),""!==e.buildingName&&"Y"===e.apartment&&(this.extraAddress+=""!==this.extraAddress?`, ${e.buildingName}`:e.buildingName),""!==this.extraAddress&&(this.extraAddress=`(${this.extraAddress})`)):this.extraAddress="",this.postcode=e.zonecode}}).open()}}},v=n(744);const A=(0,v.Z)(f,[["render",x]]);var g=A}}]);
//# sourceMappingURL=55.b6889878.js.map