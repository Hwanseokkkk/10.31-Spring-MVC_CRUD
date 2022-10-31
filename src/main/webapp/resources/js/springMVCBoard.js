$(function(){

  $("#regBtn").click(function(event){
   event.preventDefault();
    location.href = "/board/boardInsert";
  });
  
  //수정버튼 클릭시 수정 처리
    $("#updateBtn").click(function(event){
        if(confirm("진짜 바까뿐데이~~~~~~~?")){
       $("#updateForm").submit();
     }else{
     return false;
     }
    
  });
  
    //삭제버튼 클릭시 삭제 처리
    $("#deleteBtn").click(function(event){
     event.preventDefault();
    if(confirm("진짜 지운데이~~~~~~~?")){
     location.href = "/board/delete?bno="+$(this).attr("bno");
     }else{
     return false;
     }
  });
  
    //목록버튼 클릭시 목록으로~
    $("#listBtn").click(function(event){
     event.preventDefault();
    location.href = "/";
  });

});