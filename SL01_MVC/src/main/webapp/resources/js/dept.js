console.log("Dept Module........");
const deptService = (function(){
    
    
   // http://localhost/scott/dept/new 새로운 부서 추가
   // data:JSON.stringify(dept) js 객체 -> JSON
    
    
    // 부서 추가 함수
    function add(dept, callback, error){
        console.log("@@@@dept Service의 add() 호출@@@@");
        
        $.ajax({
            type:'post',
            url:'/scott/dept/new',
            data:JSON.stringify(dept),
            contentType : "application/json; charset=utf-8",
            cache:false,
            beforeSend:function(xhr){
                console.log("add.beforeSend ........");
            },
            success:function(result, status, xhr){
                if(callback){
                    callback(result);
                }
            },
            error:function(xhr, status, er){
                if(error){
                    error(er);
                }
            }
        });
    }
    
    // 부서 삭제 함수
    function remove(deptno, callback, error){
        console.log("@@@@dept Service의 remove() 호출@@@@");
        
        $.ajax({
            type:'post',
            url:'/scott/dept/remove',
            data: JSON.stringify(deptno),
            contentType : "application/json; charset=utf-8",
            cache:false,
            beforeSend:function(xhr){
                console.log("remove.beforeSend ........");
            },
            success:function(result, status, xhr){
                if(callback){
                    callback(result);
                }
            },
            error:function(xhr, status, er){
                if(error){
                    error(er);
                }
            }
        });
    }
    
    return {
        add:add,
        remove:remove
    };
})();