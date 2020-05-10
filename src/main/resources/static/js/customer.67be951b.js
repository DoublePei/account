(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["customer"],{2532:function(e,t,r){"use strict";var a=r("23e7"),i=r("5a34"),n=r("1d80"),l=r("ab13");a({target:"String",proto:!0,forced:!l("includes")},{includes:function(e){return!!~String(n(this)).indexOf(i(e),arguments.length>1?arguments[1]:void 0)}})},"44e7":function(e,t,r){var a=r("861d"),i=r("c6b6"),n=r("b622"),l=n("match");e.exports=function(e){var t;return a(e)&&(void 0!==(t=e[l])?!!t:"RegExp"==i(e))}},"49bd":function(e,t,r){},"5a34":function(e,t,r){var a=r("44e7");e.exports=function(e){if(a(e))throw TypeError("The method doesn't accept regular expressions");return e}},8418:function(e,t,r){"use strict";var a=r("c04e"),i=r("9bf2"),n=r("5c6c");e.exports=function(e,t,r){var l=a(t);l in e?i.f(e,l,n(0,r)):e[l]=r}},9803:function(e,t,r){"use strict";r.r(t);var a=function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{staticClass:"the-customer-container"},[r("el-row",{staticClass:"search-box",attrs:{gutter:20}},[r("el-col",{attrs:{span:6}},[r("span",{staticClass:"label"},[e._v("省份")]),r("el-select",{attrs:{clearable:"",filterable:"",placeholder:"请选择"},model:{value:e.filter.desc,callback:function(t){e.$set(e.filter,"desc",t)},expression:"filter.desc"}},e._l(e.PROVINCE,(function(e){return r("el-option",{key:e,attrs:{label:e,value:e}})})),1)],1),r("el-col",{attrs:{span:10}},[r("span",{staticClass:"label"},[e._v("寄件公司")]),r("el-input",{attrs:{clearable:"",filterable:"",placeholder:"输入寄件公司搜索"},model:{value:e.filter.name,callback:function(t){e.$set(e.filter,"name",t)},expression:"filter.name"}})],1)],1),r("el-row",{staticClass:"table-box"},[r("el-col",{staticClass:"total-count",attrs:{span:2}},[e._v("共"+e._s(e.pagination.total>0?e.pagination.total:0)+"条")]),r("el-col",{staticClass:"btn-action",attrs:{span:22}},[r("el-button",{attrs:{type:"primary",size:"mini",icon:"el-icon-plus"},on:{click:function(t){return e.openDialog(!0)}}},[e._v("新增寄件公司")]),r("el-button",{attrs:{type:"primary",size:"mini",icon:"el-icon-refresh"},on:{click:e.fetchUserList}},[e._v("刷新")])],1),r("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.loading,expression:"loading"}],ref:"billingTable",attrs:{data:e.tableListComputed,size:"mini",border:"","element-loading-text":"拼命加载中","element-loading-spinner":"el-icon-loading","header-cell-class-name":"table-header-custom",height:e.tableHeight}},[r("el-table-column",{attrs:{prop:"id",label:"ID",width:"70"}}),r("el-table-column",{attrs:{prop:"name",label:"寄件公司","min-width":"200"}}),r("el-table-column",{attrs:{prop:"phone",label:"联系方式","min-width":"80"}}),r("el-table-column",{attrs:{prop:"dest",label:"省份"}}),r("el-table-column",{attrs:{prop:"hprice",label:"重量单价（元）"}}),r("el-table-column",{attrs:{prop:"vprice",label:"体积单价（元）"}}),r("el-table-column",{attrs:{prop:"basePrice",label:"起步价（元）"}}),r("el-table-column",{attrs:{label:"操作",fixed:"right",width:"80"},scopedSlots:e._u([{key:"default",fn:function(t){return[r("i",{staticClass:"el-icon-edit",on:{click:function(r){return e.openDialog(!1,t.row)}}}),r("el-divider",{attrs:{direction:"vertical"}}),r("i",{staticClass:"el-icon-delete",on:{click:function(r){return e.deleteUser(t.row)}}})]}}])})],1),r("el-pagination",{attrs:{layout:"total, prev, pager, next, sizes, jumper","prev-text":"上一页","next-text":"下一页","page-sizes":[15,30,50],total:e.pagination.total,"hide-on-single-page":""},on:{"current-change":e.pageIndexChange,"size-change":e.pageIndexChange}})],1),r("el-dialog",{staticClass:"custom-dialog",attrs:{title:e.title,visible:e.dialogVisible,width:"550px","destroy-on-close":""},on:{"update:visible":function(t){e.dialogVisible=t}}},[r("el-form",{ref:"customForm",attrs:{model:e.form,rules:e.rules,"label-position":"right","label-width":"130px"}},[r("el-form-item",{attrs:{label:"寄件公司",prop:"name"}},[r("el-input",{attrs:{clearable:"",placeholder:"请填写寄件公司"},model:{value:e.form.name,callback:function(t){e.$set(e.form,"name",t)},expression:"form.name"}})],1),r("el-form-item",{attrs:{label:"联系方式",prop:"phone"}},[r("el-input",{attrs:{clearable:"",placeholder:"请填写联系方式"},model:{value:e.form.phone,callback:function(t){e.$set(e.form,"phone",t)},expression:"form.phone"}})],1),r("el-form-item",{attrs:{label:"省份",prop:"dest"}},[r("el-select",{attrs:{clearable:"",placeholder:"请选择省份"},model:{value:e.form.dest,callback:function(t){e.$set(e.form,"dest",t)},expression:"form.dest"}},e._l(e.PROVINCE,(function(e){return r("el-option",{key:e,attrs:{label:e,value:e}})})),1)],1),r("el-form-item",{attrs:{label:"重量单价（元）",prop:"hprice"}},[r("el-input",{attrs:{clearable:"",placeholder:"请填写重量单价"},model:{value:e.form.hprice,callback:function(t){e.$set(e.form,"hprice",t)},expression:"form.hprice"}})],1),r("el-form-item",{attrs:{label:"体积单价（元）",prop:"vprice"}},[r("el-input",{attrs:{clearable:"",placeholder:"请填写体积单价"},model:{value:e.form.vprice,callback:function(t){e.$set(e.form,"vprice",t)},expression:"form.vprice"}})],1),r("el-form-item",{attrs:{label:"起步价（元）",prop:"basePrice"}},[r("el-input",{attrs:{clearable:"",placeholder:"请填写起步价"},model:{value:e.form.basePrice,callback:function(t){e.$set(e.form,"basePrice",t)},expression:"form.basePrice"}})],1)],1),r("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[r("el-button",{attrs:{size:"mini"},on:{click:function(t){e.dialogVisible=!1}}},[e._v("取 消")]),r("el-button",{attrs:{size:"mini",type:"primary"},on:{click:function(t){return e.save(!0)}}},[e._v("保存")])],1)],1)],1)},i=[],n=(r("4de4"),r("caad"),r("fb6a"),r("b0c0"),r("2532"),r("96cf"),r("1da1")),l=r("60fe"),s=r("365c"),o={name:"Customer",data:function(){return{PROVINCE:l["b"],filter:{name:"",dest:""},tableHeight:100,loading:!1,dataList:[],pagination:{currentPage:1,pageSize:15,total:null},title:"",dialogVisible:!1,form:{id:null,name:"",phone:"",dest:"",hprice:"",vprice:"",basePrice:""},rules:{name:[{required:!0,message:"寄件公司不能为空",trigger:"change"}],dest:[{required:!0,message:"省份不能为空",trigger:"change"}],hprice:[{required:!0,message:"重量单价不能为空",trigger:"change"}],vprice:[{required:!0,message:"体积单价不能为空",trigger:"change"}],basePrice:[{required:!0,message:"起步价不能为空",trigger:"change"}]}}},computed:{dataListFilter:function(){var e=this;return this.filter.name&&this.filter.desc?this.dataList.filter((function(t){return t.name.includes(e.filter.name)&&t.dest.includes(e.filter.desc)})):this.dataList.filter((function(t){return e.filter.name?t.name.includes(e.filter.name):!e.filter.desc||t.dest.includes(e.filter.desc)}))},tableListComputed:function(){var e=this.pagination,t=e.currentPage,r=e.pageSize;return this.dataListFilter.slice((t-1)*r,t*r)}},created:function(){this.fetchUserList()},mounted:function(){this.getTableHeight()},methods:{fetchUserList:function(){var e=this;return Object(n["a"])(regeneratorRuntime.mark((function t(){var r,a;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return r={},t.next=3,s["a"].getUserList(r);case 3:a=t.sent,a&&1===a.code?(e.dataList=a.data||[],e.pagination.total=e.dataList.length):e.$message.error("获取客户列表异常");case 5:case"end":return t.stop()}}),t)})))()},getTableHeight:function(){var e=this;setTimeout((function(){e.tableHeight=window.innerHeight-e.$refs.billingTable.$el.offsetTop-212}),100)},pageIndexChange:function(e){this.pagination.currentPage=e},openDialog:function(){var e=!(arguments.length>0&&void 0!==arguments[0])||arguments[0],t=arguments.length>1?arguments[1]:void 0;this.dialogVisible=!0,e?(this.title="新增寄件公司",this.form.id=null):(this.title="编辑寄件公司",this.form=t)},save:function(){var e=this,t=!(arguments.length>0&&void 0!==arguments[0])||arguments[0];this.$refs.customForm.validate(function(){var r=Object(n["a"])(regeneratorRuntime.mark((function r(a){var i;return regeneratorRuntime.wrap((function(r){while(1)switch(r.prev=r.next){case 0:if(!a){r.next=7;break}return r.next=3,s["a"].saveUser(e.form);case 3:i=r.sent,i&&1===i.code?(e.$message({message:e.form.id?"编辑客户成功！":"新增客户成功！",type:"success"}),e.fetchUserList(),e.$refs.customForm.resetFields(),e.dialogVisible=!t):e.$message.error(i.message),r.next=8;break;case 7:return r.abrupt("return",!1);case 8:case"end":return r.stop()}}),r)})));return function(e){return r.apply(this,arguments)}}())},deleteUser:function(e){var t=this;this.$confirm("确定要删除：".concat(e.name," ?"),"提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(Object(n["a"])(regeneratorRuntime.mark((function r(){var a;return regeneratorRuntime.wrap((function(r){while(1)switch(r.prev=r.next){case 0:return r.next=2,s["a"].deleteUserById(e.id);case 2:a=r.sent,a&&1===a.code?(t.$message({message:"删除客户成功！",type:"success"}),t.fetchUserList()):t.$message.error(a.message);case 4:case"end":return r.stop()}}),r)}))))}}},c=o,u=(r("a5de"),r("2877")),d=Object(u["a"])(c,a,i,!1,null,null,null);t["default"]=d.exports},a5de:function(e,t,r){"use strict";var a=r("49bd"),i=r.n(a);i.a},ab13:function(e,t,r){var a=r("b622"),i=a("match");e.exports=function(e){var t=/./;try{"/./"[e](t)}catch(r){try{return t[i]=!1,"/./"[e](t)}catch(a){}}return!1}},caad:function(e,t,r){"use strict";var a=r("23e7"),i=r("4d64").includes,n=r("44d2"),l=r("ae40"),s=l("indexOf",{ACCESSORS:!0,1:0});a({target:"Array",proto:!0,forced:!s},{includes:function(e){return i(this,e,arguments.length>1?arguments[1]:void 0)}}),n("includes")},fb6a:function(e,t,r){"use strict";var a=r("23e7"),i=r("861d"),n=r("e8b5"),l=r("23cb"),s=r("50c4"),o=r("fc6a"),c=r("8418"),u=r("b622"),d=r("1dde"),p=r("ae40"),f=d("slice"),m=p("slice",{ACCESSORS:!0,0:0,1:2}),g=u("species"),h=[].slice,b=Math.max;a({target:"Array",proto:!0,forced:!f||!m},{slice:function(e,t){var r,a,u,d=o(this),p=s(d.length),f=l(e,p),m=l(void 0===t?p:t,p);if(n(d)&&(r=d.constructor,"function"!=typeof r||r!==Array&&!n(r.prototype)?i(r)&&(r=r[g],null===r&&(r=void 0)):r=void 0,r===Array||void 0===r))return h.call(d,f,m);for(a=new(void 0===r?Array:r)(b(m-f,0)),u=0;f<m;f++,u++)f in d&&c(a,u,d[f]);return a.length=u,a}})}}]);
//# sourceMappingURL=customer.67be951b.js.map