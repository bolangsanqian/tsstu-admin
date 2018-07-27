define(['jquery', 'bootstrap', 'backend', 'table', 'form', 'vue', 'common'], function ($, undefined, Backend, Table, Form, Vue, Common) {

    var Controller = {
        index: function () {
            // 初始化表格参数配置
            Table.api.init({
                extend: {
                    index_url: '/sys/admin/index',
                    add_url: '/sys/admin/add',
                    edit_url: '/sys/admin/edit',
                    del_url: '/sys/admin/del',
                    multi_url: '/sys/admin/multi',
                }
            });

            var table = $("#table");

            // 初始化表格
            table.bootstrapTable({
                //MY UPDATE |||| url: $.fn.bootstrapTable.defaults.extend.index_url,
                url: "/sys/admin/page/list.json",
                idField: "userId",
                pk: 'userId',
                columns: [
                    [
                        {field: 'state', checkbox: true },
                        {field: 'userId', title: '编号', operate: false},
                        {field: 'username', title: "账号"},
                        {field: 'nickname', title: "昵称"},
                        {field: 'realname', title: "真实姓名", operate:false, formatter: Table.api.formatter.label},
                        {field: 'email', title: "邮箱"},
                        {field: 'status', title: "状态", formatter: function (value, row, index) {
                            value = value == 1 ? "正常" : "禁用";
                            return Table.api.formatter.status.call(this, value, row, index);
                        }},
                        {field: 'createTime', title: "创建时间",  sortable: true, formatter: function (value, row, index) {
                            value = parseInt(value / 1000);
                            return Table.api.formatter.datetime.call(this, value, row, index);
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
        }
    };
    return Controller;
});
