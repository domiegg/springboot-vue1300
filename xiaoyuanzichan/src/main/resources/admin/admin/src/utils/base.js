const base = {
    get() {
        return {
            url : "http://localhost:8080/xiaoyuanzichan/",
            name: "xiaoyuanzichan",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/xiaoyuanzichan/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "校园资产管理"
        } 
    }
}
export default base
