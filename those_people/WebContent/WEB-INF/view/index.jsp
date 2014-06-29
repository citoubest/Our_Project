<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">   
    <link rel="stylesheet" type="text/css" href="../css/carousel.css">  
    
<title>首页</title>
</head>
<c:choose>
<c:when test="${!empty sessionScope.userInfo}">
<jsp:include page="/WEB-INF/view/login_header.jsp" />
</c:when>
<c:otherwise>
<jsp:include page="/WEB-INF/view/header.jsp" />
</c:otherwise>
</c:choose>
<body>
<!--首屏轮播开始-->  
    <div class="carousel slide"  data-ride="carousel" id="carousel-116699">
      <ol class="carousel-indicators">
        <li data-slide-to="0" data-target="#carousel-116699"></li>
        <li data-slide-to="1" data-target="#carousel-116699" class="active"></li>
        <li data-slide-to="2" data-target="#carousel-116699"></li>
        <li data-slide-to="3" data-target="#carousel-116699"></li>
      </ol>
      <div class="carousel-inner">
        <div class="item">
          <img alt="" src="../img/index-pic/index-banner-house.jpg" />  
          <div class="container">
            <div class="carousel-caption">
              <h4>房屋</h4>
              <p>
                需要小伙伴一起合租，想从校友那找到更合适的转租信息，想把自己的房子租给自己的学弟学妹，各种网站各种发布信息，别麻烦了！这里有你需要的小伙伴在等着你！
              </p>
            </div>
          </div>
        </div>
        <div class="item active">
          <img alt="" src="../img/index-pic/index-banner-love.jpg" />  
          <div class="container">
            <div class="carousel-caption">
              <h4>鹊桥</h4>
              <p>
                一个人，一座城市。孤独的漂流，需要心灵的陪伴。曾经的他/她是否也在这个城市，也在寻找心灵的港外？从一个母校走出来，会不会有更多的相似情怀可以共同感慨，试试看，说不定就找到了另一只同样孤单的鹊儿。
              </p>
            </div>
          </div>
        </div>
        <div class="item">
          <img alt="" src="../img/index-pic/index-banner-job.jpg" />  
          <div class="container">
            <div class="carousel-caption">
              <h4>工作</h4>
              <p>想跳槽无奈没有合适的职位，看看师兄、师姐有没有好的职位推荐？想找工作，参加各种被鄙视，各种面试？别傻了，内推才是王道啊！</p>
            </div>
          </div>
        </div>
        <div class="item">
          <img alt="" src="../img/index-pic/index-banner-activity.jpg" />  
          <div class="container">
            <div class="carousel-caption">
              <h4>活动</h4>
              <p>
                小伙伴们都在哪里？不如出来聚聚，谈谈离开学校后的蛋疼与忧桑，吐槽下生活的艰辛与绳命的美好。还等什么，快来组织校友们来活动吧！
              </p>
            </div>
          </div>
        </div>
      </div>
      <a data-slide="prev" href="#carousel-116699" class="left carousel-control">‹</a>
      <a data-slide="next" href="#carousel-116699" class="right carousel-control">›</a>
    </div>
    <!--首屏轮播结束-->  

    <div class="container" >
      <div class="row">
        <div class="row">
          <div class="col-lg-3">
            <a href="#" class="thumbnail">
              <img  src="../img/index-pic/love.jpg" class="img-polaroid" />  
            </a>
          </div>
          <div class="col-lg-3">
            <a href="#" class="thumbnail">
              <img  src="../img/index-pic/house.jpg" class="img-polaroid" />  
            </a>
          </div>
          <div class="col-lg-3">
            <a href="#" class="thumbnail">
              <img  src="../img/index-pic/job.jpg" class="img-polaroid" />  
            </a>
          </div>
          <div class="col-lg-3">
            <a href="#" class="thumbnail">
              <img  src="../img/index-pic/activity.jpg" class="img-polaroid" />  
            </a>
          </div>
        </div>
        <div class="row">
          <div class="col-lg-3">
            <h2>鹊桥</h2>
            <p>
              现在的你是否为曾经的自己没勇气表白而后悔，时隔多年，她过得还好吗？她还是向当年校园里那样一个人一本书独来独往吗？找到曾经的她，为现在的你！
            </p>
          </div>
          <div class="col-lg-3">
            <h2>房屋</h2>
            <p>
              在这个偌大的城市里，你孤身拼搏，想为自己找个舒适的窝，但是总想有曾经校园的兄弟姐妹陪伴，试试看，也去他们也在寻找你，合租，转租和曾经的兄弟姐妹一起！
            </p>
          </div>
          <div class="col-lg-3">
            <h2>工作</h2>
            <p>想要找内退，想要找学弟学妹，想要和学弟学妹分享工作经验，想要向学长学姐交流工作经验，这里有你需要的。</p>
          </div>
          <div class="col-lg-3">
            <h2>活动</h2>
            <p>要聚餐，要运动，要桌游，无奈找不到人陪，曾经的小伙伴们在哪啊！上来看看有没有曾经的小伙伴和你一样在找人活动啊！</p>
          </div>
        </div>
      </div>
      <div class="container">
        <div class="row">
          <div class="col-md-12"></div>
        </div>
      </div>
      <hr class="featurette-divider">  
</body>
</html>