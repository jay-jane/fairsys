const path = require("path");
let devpath ='';    //개발환경 사용시 설정
// const devpath = '../templates/'; //최종빌드 패스

if(process.env.NODE_ENV==='production'){
  devpath='../templates/';
  console.log(process.env.NODE_EN);
}
module.exports = {

  productionSourceMap: process.env.NODE_ENV !== 'production',



  //개발환경 사용시에는 주석처리
  // //vue 프로젝트 실행시 프록시 설정을 통해 vue개발용 서버가 처리하지 못하는 요청을 백엔드 포트로 요청
  devServer:{
    port: 8081, //vue의 기본포트
    //Proxy: 'http://localhost:8787' //백엔드 포트주소
    proxy: 'http://localhost:8787'
  },

  //vue 프로젝트 빌드 경로(css,js파일)

  outputDir: path.resolve(__dirname, "../backend/src/main/resources/static"),

  pages:{

    page1:{
      entry: 'src/pages/page1/main.js', 
      template: 'public/templates/page1.html',  //html 파일의 경로
      filename: devpath + 'page1.html'          //html 파일 생성경로
    },
    page2:{
      entry: 'src/pages/page2/main.js',
      template: 'public/templates/page2.html',
      filename: devpath + 'page2.html',
    },
    page3:{
      entry: 'src/pages/page3/main.js',
      template: 'public/templates/page3.html',
      filename: devpath + 'page3.html',
    },
    page4:{
      entry: 'src/pages/page4/main.js',
      template: 'public/templates/page4.html',
      filename: devpath + 'page4.html',
    },
    page5:{
      entry: 'src/pages/page5/main.js',
      template: 'public/templates/page5.html',
      filename: devpath + 'page5.html',
    },
    page6:{
      entry: 'src/pages/page6/main.js',
      template: 'public/templates/page6.html',
      filename: devpath + 'page6.html',
    },
    page7:{
      entry: 'src/pages/page7/main.js',
      template: 'public/templates/page7.html',
      filename: devpath + 'page7.html',
    },
    page8:{
      entry: 'src/pages/page8/main.js',
      template: 'public/templates/page8.html',
      filename: devpath + 'page8.html',
    },
    page9:{
      entry: 'src/pages/page9/main.js',
      template: 'public/templates/page9.html',
      filename: devpath + 'page9.html',
    },
    page10:{
      entry: 'src/pages/page10/main.js',
      template: 'public/templates/page10.html',
      filename: devpath + 'page10.html',
    },
    page30:{
      entry: 'src/pages/page30/main.js',
      template: 'public/templates/page30.html',
      filename: devpath + 'page30.html',
    },
    page31:{
      entry: 'src/pages/page31/main.js',
      template: 'public/templates/page31.html',
      filename: devpath + 'page31.html',
    }
  }
}

