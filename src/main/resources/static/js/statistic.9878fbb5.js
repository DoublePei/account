(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["statistic"],{d8d7:function(t,e,a){"use strict";var n=a("e46a"),i=a.n(n);i.a},e46a:function(t,e,a){},eff6:function(t,e,a){"use strict";a.r(e);var n=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"the-statistic-container"},[a("el-row",{staticClass:"search-box",attrs:{gutter:20}},[a("el-col",{attrs:{span:6}},[a("span",{staticClass:"label"},[t._v("日期")]),a("el-date-picker",{attrs:{clear:"",type:"daterange","range-separator":"~","start-placeholder":"开始日期","end-placeholder":"结束日期","value-format":"yyyy-MM-dd"},on:{clear:t.fetchStatisticList,change:t.fetchStatisticList},model:{value:t.filter.date,callback:function(e){t.$set(t.filter,"date",e)},expression:"filter.date"}})],1),a("el-col",{attrs:{span:10}},[a("span",{staticClass:"label"},[t._v("寄件公司")]),a("el-input",{attrs:{clearable:"",filterable:"",placeholder:"输入寄件公司搜索"},nativeOn:{keydown:function(e){return!e.type.indexOf("key")&&t._k(e.keyCode,"enter",13,e.key,"Enter")?null:t.fetchStatisticList(e)}},model:{value:t.filter.company,callback:function(e){t.$set(t.filter,"company",e)},expression:"filter.company"}})],1)],1),a("el-row",{staticClass:"table-box"},[a("el-col",{staticClass:"total-count",attrs:{span:2}},[t._v("共"+t._s(t.pagination.total>0?t.pagination.total:0)+"条")]),a("el-col",{staticClass:"btn-action",attrs:{span:22}},[a("el-button",{attrs:{type:"primary",size:"mini",icon:"el-icon-refresh"},on:{click:t.fetchStatisticList}},[t._v("刷新")])],1),a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:t.loading,expression:"loading"}],ref:"billingTable",attrs:{size:"mini",data:t.dataList,"element-loading-text":"拼命加载中","element-loading-spinner":"el-icon-loading","header-cell-class-name":"table-header-custom",height:t.tableHeight}},[a("el-table-column",{attrs:{label:"寄件日期",idth:"100"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("span",[t._v(t._s(t._f("dateFormat")(e.row.date)))])]}}])}),a("el-table-column",{attrs:{prop:"name",label:"寄件公司","min-width":"200"}}),a("el-table-column",{attrs:{prop:"num",label:"件数"}}),a("el-table-column",{attrs:{prop:"price",label:"总金额"}}),a("el-table-column",{attrs:{prop:"cost",label:"总成本"}}),a("el-table-column",{attrs:{prop:"profit",label:"总利润"}})],1),a("el-pagination",{attrs:{layout:"total, prev, pager, next, sizes, jumper","prev-text":"上一页","next-text":"下一页","page-sizes":[15,30,50],total:t.pagination.total,"hide-on-single-page":""},on:{"current-change":t.pageIndexChange,"size-change":t.pageIndexChange}})],1)],1)},i=[],l=(a("4de4"),a("96cf"),a("1da1")),r=a("c1df"),s=a.n(r),o=a("60fe"),c=a("365c"),d={name:"Statistic",filters:{dateFormat:function(t){return t?s()(t).format("YYYY-MM-DD"):t}},data:function(){return{PROVINCE:o["b"],filter:{date:"",company:""},tableHeight:100,loading:!1,dataList:[],pagination:{currentPage:1,pageSize:15,total:null}}},created:function(){this.fetchStatisticList()},mounted:function(){this.getTableHeight()},methods:{fetchStatisticList:function(){var t=arguments,e=this;return Object(l["a"])(regeneratorRuntime.mark((function a(){var n,i,l;return regeneratorRuntime.wrap((function(a){while(1)switch(a.prev=a.next){case 0:return n=!(t.length>0&&void 0!==t[0])||t[0],e.loading=n,i={page:e.pagination.currentPage,size:e.pagination.pageSize,sortProperties:"cost",sortDirection:"desc",startTime:e.filter.date&&e.filter.date.length>1?s()(e.filter.date[0]).startOf("day").format("YYYY-MM-DD HH:mm:ss"):"",endTime:e.filter.date&&e.filter.date.length>1?s()(e.filter.date[1]).endOf("day").format("YYYY-MM-DD HH:mm:ss"):"",company:e.filter.company},a.next=5,c["a"].getStatisticList(i);case 5:l=a.sent,l&&1===l.code&&(e.dataList=l.data.data||[],e.pagination.total=l.data.total),e.loading=!1;case 8:case"end":return a.stop()}}),a)})))()},getTableHeight:function(){var t=this;setTimeout((function(){t.tableHeight=window.innerHeight-t.$refs.billingTable.$el.offsetTop-212}),100)},pageIndexChange:function(t){this.pagination.currentPage=t,this.fetchStatisticList()}}},p=d,f=(a("d8d7"),a("2877")),u=Object(f["a"])(p,n,i,!1,null,null,null);e["default"]=u.exports}}]);
//# sourceMappingURL=statistic.9878fbb5.js.map