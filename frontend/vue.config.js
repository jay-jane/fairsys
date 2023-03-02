
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
    page11:{
      entry: 'src/pages/page11/main.js',
      template: 'public/templates/page11.html',
      filename: devpath + 'page11.html',
    },
    page12:{
      entry: 'src/pages/page12/main.js',
      template: 'public/templates/page12.html',
      filename: devpath + 'page12.html',
    },
    page13:{
      entry: 'src/pages/page13/main.js',
      template: 'public/templates/page13.html',
      filename: devpath + 'page13.html',
    },
    page14:{
      entry: 'src/pages/page14/main.js',
      template: 'public/templates/page14.html',
      filename: devpath + 'page14.html',
    },
    page15:{
      entry: 'src/pages/page15/main.js',
      template: 'public/templates/page15.html',
      filename: devpath + 'page15.html',
    },
    page16:{
      entry: 'src/pages/page16/main.js',
      template: 'public/templates/page16.html',
      filename: devpath + 'page16.html',
    },
    page17:{
      entry: 'src/pages/page17/main.js',
      template: 'public/templates/page17.html',
      filename: devpath + 'page17.html',
    },
    page18:{
      entry: 'src/pages/page18/main.js',
      template: 'public/templates/page18.html',
      filename: devpath + 'page18.html',
    },
    page19:{
      entry: 'src/pages/page19/main.js',
      template: 'public/templates/page19.html',
      filename: devpath + 'page19.html',
    },
    page20:{
      entry: 'src/pages/page20/main.js',
      template: 'public/templates/page20.html',
      filename: devpath + 'page20.html',
    },
    page21:{
      entry: 'src/pages/page21/main.js',
      template: 'public/templates/page21.html',
      filename: devpath + 'page21.html',
    },
    page22:{
      entry: 'src/pages/page22/main.js',
      template: 'public/templates/page22.html',
      filename: devpath + 'page22.html',
    },
    page23:{
      entry: 'src/pages/page23/main.js',
      template: 'public/templates/page23.html',
      filename: devpath + 'page23.html',
    },
    page24:{
      entry: 'src/pages/page24/main.js',
      template: 'public/templates/page24.html',
      filename: devpath + 'page24.html',
    },
    page25:{
      entry: 'src/pages/page25/main.js',
      template: 'public/templates/page25.html',
      filename: devpath + 'page25.html',
    },
    page26:{
      entry: 'src/pages/page26/main.js',
      template: 'public/templates/page26.html',
      filename: devpath + 'page26.html',
    },
    page27:{
      entry: 'src/pages/page27/main.js',
      template: 'public/templates/page27.html',
      filename: devpath + 'page27.html',
    },
    page28:{
      entry: 'src/pages/page28/main.js',
      template: 'public/templates/page28.html',
      filename: devpath + 'page28.html',
    },
    page29:{
      entry: 'src/pages/page29/main.js',
      template: 'public/templates/page29.html',
      filename: devpath + 'page29.html',
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
    },
    page32:{
      entry: 'src/pages/page32/main.js',
      template: 'public/templates/page32.html',
      filename: devpath + 'page32.html',
    },
    page33:{
      entry: 'src/pages/page33/main.js',
      template: 'public/templates/page33.html',
      filename: devpath + 'page33.html',
    },
    page34:{
      entry: 'src/pages/page34/main.js',
      template: 'public/templates/page34.html',
      filename: devpath + 'page34.html',
    },
    page35:{
      entry: 'src/pages/page35/main.js',
      template: 'public/templates/page35.html',
      filename: devpath + 'page35.html',
    },
    page36:{
      entry: 'src/pages/page36/main.js',
      template: 'public/templates/page36.html',
      filename: devpath + 'page36.html',
    },
    page37:{
      entry: 'src/pages/page37/main.js',
      template: 'public/templates/page37.html',
      filename: devpath + 'page37.html',
    },
    page38:{
      entry: 'src/pages/page38/main.js',
      template: 'public/templates/page38.html',
      filename: devpath + 'page38.html',
    },
    page39:{
      entry: 'src/pages/page39/main.js',
      template: 'public/templates/page39.html',
      filename: devpath + 'page39.html',
    },
    page40:{
      entry: 'src/pages/page40/main.js',
      template: 'public/templates/page40.html',
      filename: devpath + 'page40.html',
    },
    page41:{
      entry: 'src/pages/page41/main.js',
      template: 'public/templates/page41.html',
      filename: devpath + 'page41.html',
    },
    page42:{
      entry: 'src/pages/page42/main.js',
      template: 'public/templates/page42.html',
      filename: devpath + 'page42.html',
    },
    page43:{
      entry: 'src/pages/page43/main.js',
      template: 'public/templates/page43.html',
      filename: devpath + 'page43.html',
    },
    page44:{
      entry: 'src/pages/page44/main.js',
      template: 'public/templates/page44.html',
      filename: devpath + 'page44.html',
    },
    page45:{
      entry: 'src/pages/page45/main.js',
      template: 'public/templates/page45.html',
      filename: devpath + 'page45.html',
    },
    page46:{
      entry: 'src/pages/page46/main.js',
      template: 'public/templates/page46.html',
      filename: devpath + 'page46.html',
    },
    page47:{
      entry: 'src/pages/page47/main.js',
      template: 'public/templates/page47.html',
      filename: devpath + 'page47.html',
    },
    page48:{
      entry: 'src/pages/page48/main.js',
      template: 'public/templates/page48.html',
      filename: devpath + 'page48.html',
    },
    page49:{
      entry: 'src/pages/page49/main.js',
      template: 'public/templates/page49.html',
      filename: devpath + 'page49.html',
    },
    page50:{
      entry: 'src/pages/page50/main.js',
      template: 'public/templates/page50.html',
      filename: devpath + 'page50.html',
    },
    page51:{
      entry: 'src/pages/page51/main.js',
      template: 'public/templates/page51.html',
      filename: devpath + 'page51.html',
    },
    page52:{
      entry: 'src/pages/page52/main.js',
      template: 'public/templates/page52.html',
      filename: devpath + 'page52.html',
    },
    page53:{
      entry: 'src/pages/page53/main.js',
      template: 'public/templates/page53.html',
      filename: devpath + 'page53.html',
    },
    page54:{
      entry: 'src/pages/page54/main.js',
      template: 'public/templates/page54.html',
      filename: devpath + 'page54.html',
    },
    page55:{
      entry: 'src/pages/page55/main.js',
      template: 'public/templates/page55.html',
      filename: devpath + 'page55.html',
    },
    page56:{
      entry: 'src/pages/page56/main.js',
      template: 'public/templates/page56.html',
      filename: devpath + 'page56.html',
    },
    page57:{
      entry: 'src/pages/page57/main.js',
      template: 'public/templates/page57.html',
      filename: devpath + 'page57.html',
    },
    page58:{
      entry: 'src/pages/page58/main.js',
      template: 'public/templates/page58.html',
      filename: devpath + 'page58.html',
    },
    page59:{
      entry: 'src/pages/page59/main.js',
      template: 'public/templates/page59.html',
      filename: devpath + 'page59.html',
    },
    page60:{
      entry: 'src/pages/page60/main.js',
      template: 'public/templates/page60.html',
      filename: devpath + 'page60.html',
    }
  }
}

