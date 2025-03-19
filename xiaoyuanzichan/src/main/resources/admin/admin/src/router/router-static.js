import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'

         import users from '@/views/modules/users/list'
        import baofei from '@/views/modules/baofei/list'
        import dictionary from '@/views/modules/dictionary/list'
        import jieyong from '@/views/modules/jieyong/list'
        import shangpin from '@/views/modules/shangpin/list'
        import shangpinChuruInout from '@/views/modules/shangpinChuruInout/list'
        import shangpinChuruInoutList from '@/views/modules/shangpinChuruInoutList/list'
        import weixiu from '@/views/modules/weixiu/list'
        import yonghu from '@/views/modules/yonghu/list'
        import dictionaryBumen from '@/views/modules/dictionaryBumen/list'
        import dictionaryDidian from '@/views/modules/dictionaryDidian/list'
        import dictionaryGuihuan from '@/views/modules/dictionaryGuihuan/list'
        import dictionarySex from '@/views/modules/dictionarySex/list'
        import dictionaryShangpin from '@/views/modules/dictionaryShangpin/list'
        import dictionaryShangpinChuruInout from '@/views/modules/dictionaryShangpinChuruInout/list'





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    } ,{
        path: '/users',
        name: '管理信息',
        component: users
      }
    ,{
        path: '/dictionaryBumen',
        name: '部门类型名称',
        component: dictionaryBumen
    }
    ,{
        path: '/dictionaryDidian',
        name: '存放地点类型名称',
        component: dictionaryDidian
    }
    ,{
        path: '/dictionaryGuihuan',
        name: '是否归还',
        component: dictionaryGuihuan
    }
    ,{
        path: '/dictionarySex',
        name: '性别类型名称',
        component: dictionarySex
    }
    ,{
        path: '/dictionaryShangpin',
        name: '资产类型名称',
        component: dictionaryShangpin
    }
    ,{
        path: '/dictionaryShangpinChuruInout',
        name: '入库类型名称',
        component: dictionaryShangpinChuruInout
    }


    ,{
        path: '/baofei',
        name: '资产报废',
        component: baofei
      }
    ,{
        path: '/dictionary',
        name: '字典',
        component: dictionary
      }
    ,{
        path: '/jieyong',
        name: '资产借用',
        component: jieyong
      }
    ,{
        path: '/shangpin',
        name: '校园资产',
        component: shangpin
      }
    ,{
        path: '/shangpinChuruInout',
        name: '入库',
        component: shangpinChuruInout
      }
    ,{
        path: '/shangpinChuruInoutList',
        name: '入库详情',
        component: shangpinChuruInoutList
      }
    ,{
        path: '/weixiu',
        name: '资产维修',
        component: weixiu
      }
    ,{
        path: '/yonghu',
        name: '用户',
        component: yonghu
      }


    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
