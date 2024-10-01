<%-- 
    Document   : Footer
    Created on : Feb 24, 2024, 9:06:09 PM
    Author     : phamd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Footer -->
<footer class="text-light">
    <div class="container">
        <div class="row">
            <div class="col-md-3 col-lg-4 col-xl-3">
                    <p>Chúng tôi xin chân thành cảm ơn bạn đã quan tâm và ủng hộ cửa hàng của chúng tôi!</p>
                    <p>Hãy tiếp tục theo dõi và mua sắm tại cửa hàng thương hiệu của chúng tôi để trải nghiệm những sản phẩm chất lượng và dịch vụ tốt nhất.</p>
                    <p>Xin chân thành cảm ơn!</p>
            </div>

            <div class="col-md-2 col-lg-2 col-xl-2 mx-auto">
                <h5>Informations</h5>
                <hr class="bg-white mb-2 mt-0 d-inline-block mx-auto w-25">
                <ul class="list-unstyled">
                    <li><a href="managercategory">Manager Category</a></li>
                    <li><a href="manager">Manager Product</a></li>
                    <li><a href="Profile.jsp?accountid=${sessionScope.account.accountid}">Profile</a></li>
                </ul>
            </div>

            <div class="col-md-3 col-lg-2 col-xl-2 mx-auto">
                <h5>Maps</h5>
                <hr class="bg-white mb-2 mt-0 d-inline-block mx-auto w-25">
                <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3724.5063419425146!2d105.5227142760667!3d21.01241668063284!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3135abc60e7d3f19%3A0x2be9d7d0b5abcbf4!2sFPT%20University!5e0!3m2!1sen!2s!4v1709061810649!5m2!1sen!2s" width="100%"style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
            </div>

            <div class="col-md-4 col-lg-3 col-xl-3">
                <h5>Contact</h5>
                <hr class="bg-white mb-2 mt-0 d-inline-block mx-auto w-25">
                <ul class="list-unstyled">
                    <li><i class="fa fa-home mr-2"></i>FPT University HOALAC</li>
                    <li><i class="fa fa-envelope mr-2"></i> tuantvhe180495@fpt.edu.vn</li>
                    <li><i class="fa fa-phone mr-2"></i>0327066228</li>
<!--                    <li><i class="fa fa-print mr-2"></i>0123456789</li>-->
                </ul>
            </div>
            <div class="col-12 copyright mt-3">
                <p class="float-left">
                    <a href="#">Back to top</a>
                </p>
                <p class="text-right text-muted">created with <i class="fa fa-heart"></i> by <a href="https://www.facebook.com/abcabc.tuan.7"><i>Tuan Trinh</i></a> | <span>2024</span></p>
            </div>
        </div>
    </div>
</footer>