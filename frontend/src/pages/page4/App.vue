
<template>
 <div id="menu">
  <img src="#" style="float:left" >
	<ul>
		<li><a href="page4">공고</a>
			<ul>
				<li><a href="page52">공고상세페이지</a></li>				
			</ul>
		</li>
		<li><a href="page3">업체</a>
			<ul>
				<li><a href="page53">업체상세페이지</a></li>		
			</ul>
		</li>
		<li><a href="page42">통계</a></li>
		<li><a href="page9">Q&A</a>
			<ul>
				<li><a href="#">등록</a></li>
				<li><a href="#">내역확인</a></li>			
			</ul>
		</li>
	</ul>
  <button style="float:right">로그아웃</button>
</div>

<section id="section">
<h3 id="first_name">공고페이지</h3>

      


      <table>
        <tr>
            <td id="fj">번호</td>
            <td id="fj">회사이름</td>
            <td id="fj">모집제목</td>
            <td id="fj">시작일</td>
            <td id="fj">마감일</td>
        </tr>
        <tr>
            <td>wwww</td>
            <td>www</td>
            <td>wwww</td>
            <td>wwww</td>
            <td>www</td>
        </tr>
        <tr>
            <td>wwww</td>
            <td>www</td>
            <td>wwww</td>
            <td>wwww</td>
            <td>www</td>
        </tr>
    </table>
 
</section> 






<footer  id="ft" style="border-top: 1px solid">

<h3>여기 푸터야 </h3>



</footer>
</template>

<script>

export default {
  name: 'App'
}
</script>

<style>
* {
		margin: 0;
		padding: 0;
	}
	a {
		text-decoration: none;
		color:white;
	}
	#menu {
		font:bold 16px "malgun gothic";
		width:100%;
		height:50px;
		background: black;
		color:black;
		line-height: 50px; 
		margin:0 auto;
		text-align: center;
		padding: auto;
		border-bottom: 1px solid;
		
	}
	#menu > ul {
	list-style:none;
	display:inline-block;
	text-align: center;
	}



	#menu > ul > li {
		float:left;
		width:140px;
		position:relative;
	}
	#menu > ul > li > ul {
		width:130px;
		display:none;
		position: absolute;
		font-size:14px;
		background: skyblue;
		list-style:none;
	}
	#menu > ul > li:hover > ul {
		display:block;
		
	}
	#menu > ul > li > ul > li:hover {
		background: orange;
		transition: ease 1s;
		}
    
 #fj {
    background: wheat;
  }


#section{
  margin-top: 10px;
}

#first_name{
  text-align: center;
}

table {
  margin-left:auto; 
  margin-right:auto;
  border: 1px #444444 solid;
  font-size: .9em;
  box-shadow: 0 2px 5px rgba(0,0,0,.25);
  width: 50%;
  border-collapse: collapse;
  border-radius: 5px;
  margin-top: 10px;

  
}

 td, th {
  padding: 1em .5em;
  vertical-align: middle;
}
  
 td {
  border-bottom: 1px solid rgba(0,0,0,.1);
  background: #fff;
}


#ft {

text-align: center;
border-bottom: 1px solid black;
background: black;

}

#ft >h3 {
	color:azure;
}








</style>
