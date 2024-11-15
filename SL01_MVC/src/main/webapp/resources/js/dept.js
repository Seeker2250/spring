console.log("Dept Module........");
const deptService = (function(){
    
    
   // http://localhost/scott/dept/new 새로운 부서 추가
   // data:JSON.stringify(dept) js 객체 -> JSON
    
    
    // 부서 추가 함수
    function add(dept, callback, error){//dept는 js객체 dept
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
                if(callback){//이거 없으면 callback 없을 때 곤란해져 js에선 parameter 없을 수도 있잖아
                    callback(result);
                }
            },
            error:function(xhr, status, er){
                if(error){
                    error(er);
                }
            }
        });
    } // add


     // http://localhost/scott/dept/delete?deptno=50 해당 부서 삭제
     // http://localhost/scott/dept/50 해당 부서 삭제, 이렇게 주소에 담아서 가져가면 하나의 주소로 GET/POST/DELETE/PUT 등 다 가능하잖아!
     // data:JSON.stringify(dept) js 객체 -> JSON    
	 // 부서 삭제 함수
   /* function remove(deptno, callback, error){
        console.log("@@@@dept Service.remove() 호출@@@@");
        
        $.ajax({
            type:'get',
            url:'/scott/dept/delete',
            data:`dept=${deptno}`,//json으로 보낼 필요 없지 js니까 \도 필요없어, json 아니니까 contentType 명시도 필요없어
            cache:false,
            beforeSend:function(xhr){
                console.log("remove.beforeSend ........");
            },
            success:function(result, status, xhr){
                if(callback){//이거 없으면 callback 없을 때 곤란해져 js에선 parameter 없을 수도 있잖아
                    callback(result);
                }
            },
            error:function(xhr, status, er){
                if(error){
                    error(er);
                }
            }
        });
    }*/
    
     // DELETE + http://localhost/scott/dept/50 부서 삭제
     // RESTful API
    function remove(deptno, callback, error){
        console.log("@@@@dept Service.remove() 호출@@@@");
        
        $.ajax({
            type:'delete',
            url:`/scott/dept/${deptno}`,
            //data도 필요없어
            cache:false,
            beforeSend:function(xhr){
                console.log("remove.beforeSend ........");
            },
            success:function(result, status, xhr){
                if(callback){//이거 없으면 callback 없을 때 곤란해져 js에선 parameter 없을 수도 있잖아
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

    // 내가 만든 부서 삭제 함수
  /*  function remove(deptno, callback, error){
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
    } */