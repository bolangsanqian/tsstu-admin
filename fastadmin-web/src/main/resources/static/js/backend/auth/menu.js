define(['jquery', 'bootstrap', 'backend', 'table', 'form', 'vue', 'common'], function ($, undefined, Backend, Table, Form, Vue, Common) {

    var v = new Vue({
        el: "#main",
        data: {
            row: {}
        },
        methods: {
            index: function () {
                // 初始化表格参数配置
                Table.api.init({
                    extend: {
                        index_url: '/sys/menu/index',
                        add_url: '/sys/menu/add',
                        edit_url: '/sys/menu/edit',
                        del_url: '/sys/menu/del',
                        multi_url: '/sys/menu/multi',
                    }
                });

                var table = $("#table");

                // 初始化表格
                table.bootstrapTable({
                    //MY UPDATE |||| url: $.fn.bootstrapTable.defaults.extend.index_url,
                    url: "/sys/menu/page/list.json",
                    idField: "resourceId",
                    pk: 'resourceId',
                    columns: [
                        [
                            {field: 'chk', checkbox: true },
                            {field: 'name', title: '菜单名称', operate: false},
                            {field: 'url', title: "资源地址"},
                            {field: 'persstionTag', title: "权限标识"},
                            {field: 'remark', title: "备注", operate:false, formatter: Table.api.formatter.label},
                            {field: 'status', title: "状态", formatter: function (value, row, index) {
                                    value = value == 1 ? "正常" : "禁用";
                                    return Table.api.formatter.status.call(this, value, row, index);
                                }},
                            {field: 'operate', title: "操作", table: table, events: Table.api.events.operate, formatter: Table.api.formatter.operate}
                        ]
                    ]
                });

                // 为表格绑定事件
                Table.api.bindevent(table);
            },
            add: function () {
                Form.api.bindevent($("form[role=form]"));
            },
            edit: function () {
                Form.api.bindevent($("form[role=form]"));
                var id = Common.urlParam("id")
                this.loadDetail(id);
            },
            loadDetail: function(id) {
                var vm = this;
                var url = "/sys/menu/detail/" + id
                $.getJSON(url, {}, function (ret) {
                    if (ret.ok) {
                        vm.row = ret.data;
                    } else {
                        Toastr.error(ret.msg);
                    }
                });
            }
        }
    });

    return v;
});
