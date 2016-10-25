FROM registry.afanqie.cn/jdk8
ENV LANG en_US.UTF-8
ADD fqxz-web-1.0.0.jar app.jar
ADD start.sh /start.sh
RUN chmod a+x /start.sh
ENTRYPOINT ["/start.sh"]

