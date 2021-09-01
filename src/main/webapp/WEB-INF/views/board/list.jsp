<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../includes/header.jsp" %>
        <!-- Main content -->

        <!-- Content Wrapper. Contains page content -->
        <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <div class="container-fluid">
                    <div class="row mb-2">
                        <div class="col-sm-6">
                            <h1>List page</h1>
                        </div>
                        <div class="col-sm-6">
                            <ol class="breadcrumb float-sm-right">
                                <li class="breadcrumb-item"><a href="#">Home</a></li>
                                <li class="breadcrumb-item active">Simple Tables</li>
                            </ol>
                        </div>
                    </div>
                </div><!-- /.container-fluid -->
            </section>

            <!-- Main content -->
            <section class="content">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="card">
                                <div class="card-header">
                                    <h3 class="card-title">Bordered Table</h3>
                                </div>
                                <!-- /.card-header -->
                                <div class="card-body">
                                    <table class="table table-bordered">
                                        <thead>
                                        <tr>
                                            <th style="width: 20px">#</th>
                                            <th>TITLE</th>
                                            <th>WRITER</th>
                                            <th>REGDATE</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${dtoList}" var="dto">
                                        <tr>
                                            <td><c:out value="${dto.bno}"></c:out></td>
                                            <td><c:out value="${dto.title}"></c:out></td>
                                            <td><c:out value="${dto.writer}"></c:out></td>
                                            <td><c:out value="${dto.regDate}"></c:out></td>
                                        </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                                <!-- /.card-body -->
                                <div class="card-footer clearfix">
                                    <ul class="pagination pagination-sm m-0 float-right">
<%--                                        <li class="page-item"><a class="page-link" href="#">&laquo;</a></li>--%>
<%--                                        <li class="page-item"><a class="page-link" href="#">1</a></li>--%>
<%--                                        <li class="page-item"><a class="page-link" href="#">2</a></li>--%>
<%--                                        <li class="page-item"><a class="page-link" href="#">3</a></li>--%>
<%--                                        <li class="page-item"><a class="page-link" href="#">&raquo;</a></li>--%>

                                        <c:if test="${pageMaker.prev}">
                                            <li class = "paginate_button previous"><a href="#">Previous</a>
                                            </li>
                                        </c:if>

                                        <c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
                                            <li class="paginate_button"><a href="#">${num}</a> </li>
                                        </c:forEach>

                                        <c:if test="${pageMaker.next}">
                                            <li class="paginate_button next"><a href="#">Next</a> </li>
                                        </c:if>
                                    </ul>
                                </div>
                                <!-- end Pagination-->
                            </div>
                            <!-- /.card -->
                    <!-- /.Left col -->

                </div>
                <!-- /.row (main row) -->
            </div><!-- /.container-fluid -->
        <!-- /.content -->
    </div>
            </section>
        </div>
    <!-- /.content-wrapper -->

<div class="modal fade" id="modal-sm">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Small Modal</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>One fine body&hellip;</p>
            </div>
            <div class="modal-footer justify-content-between">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Save changes</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>
<!-- /.modal -->

<%@ include file="../includes/footer.jsp" %>


<script>
    const result = '${result}'

    if(result && result !== ''){
        $('#modal-sm').modal('show')
        window.history.replaceState(null, '', '/board/list');
    }


</script>

    





</body>
</html>
