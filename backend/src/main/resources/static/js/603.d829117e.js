"use strict";(self["webpackChunkfrontend"]=self["webpackChunkfrontend"]||[]).push([[603],{1603:function(t,l,n){n.r(l),n.d(l,{default:function(){return g}});var e=n(6252),o=n(9963),a=n(3577);const i=(0,e._)("option",{value:"1"},"1개 보기",-1),u=(0,e._)("option",{value:"2"},"2개 보기",-1),s=(0,e._)("option",{value:"3"},"3개 보기",-1),_=[i,u,s],d={class:"bg"},c=(0,e._)("h3",{class:"first_name"},"기업",-1),r=(0,e._)("thead",null,[(0,e._)("tr",null,[(0,e._)("th",{class:"jb-th-1"},"번호"),(0,e._)("th",{class:"jb-th-2"},"회사이름"),(0,e._)("th",{class:"jb-th-3"},"신청일자"),(0,e._)("th",{class:"jb-th-3"},"승인일자")])],-1),h=(0,e._)("footer",{id:"ft",style:{"border-top":"1px solid"}},[(0,e._)("h3",null,"여기 푸터야")],-1);function m(t,l,n,i,u,s){return(0,e.wg)(),(0,e.iD)(e.HY,null,[(0,e.wy)((0,e._)("select",{"onUpdate:modelValue":l[0]||(l[0]=t=>u.com_id=t)},_,512),[[o.bM,u.com_id]]),(0,e._)("section",null,[(0,e._)("div",d,[c,(0,e._)("table",null,[r,(0,e._)("tbody",null,[((0,e.wg)(!0),(0,e.iD)(e.HY,null,(0,e.Ko)(u.list,((t,l)=>((0,e.wg)(),(0,e.iD)("tr",null,[(0,e._)("td",null,(0,a.zw)(t.com_id),1),(0,e._)("td",null,(0,a.zw)(t.com_name),1),(0,e._)("td",null,(0,a.zw)(t.com_num),1)])))),256))])])]),(0,e.wy)((0,e._)("input",{type:"text","onUpdate:modelValue":l[1]||(l[1]=t=>u.com_id=t)},null,512),[[o.nr,u.com_id]])]),h],64)}var p=n(6154),f={name:"App",data(){return{com_id:1,list:""}},watch:{com_id:function(){this.get()}},methods:{logout(){location.href="/3"},async get(){let t=await p.Z.get("/18/data?com_id="+this.com_id);this.list=t.data}},mounted(){this.get()}},w=n(3744);const b=(0,w.Z)(f,[["render",m]]);var g=b}}]);
//# sourceMappingURL=603.d829117e.js.map