<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- Forms Validations Plugin -->
<script src="https://cdn.bootcss.com/jquery-validate/1.14.0/jquery.validate.min.js"></script>
<script type="text/javascript">
    //设置 表单验证
    function setFormValidation(id) {
        $(id).validate({
            errorPlacement: function(error, element) {
                $(element).parent('div').addClass('has-error');
            }
        });
    }
//    $(document).ready(function() {
//        setFormValidation('#LoginValidation');
//        setFormValidation('#RangeValidation');
//    });
</script>
