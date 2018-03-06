/*
* Powered By [javasaasx]
* Web Site: http://solrhome.com
* Github Code: https://github.com/choudou5
* License：MIT
* Since 2018 - 2020
*/


/** 系统设置 业务JS  */

/**
 * 编辑
 */
function edit(){

}


/**
 * 构建 数据表格
 */
function buildDataTable(){
    var datatables = $('#datatables').DataTable({
        "pagingType": "full_numbers",
        "lengthMenu": [
            [10, 25, 50, -1],
            [10, 25, 50, "All"]
        ],
        responsive: true,
        language: {
            search: "_INPUT_",
            searchPlaceholder: "Search",
        }
    });
    // Delete a record
    datatables.on('click', '.remove', function(e) {
        var href = $(this).data("href");
        tr = $(this).closest('tr');
        dialogConfirmAjaxDel(href, datatables, tr);
        e.preventDefault();
    });
}