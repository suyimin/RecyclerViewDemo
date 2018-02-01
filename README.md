# RecyclerViewDemo
刷新RecyclerView时，如何解决因系统复用item导致的图片错乱。原理就是对重用的itemView里面的内容被重新赋值。
如果是异步加载图片，要将tag设置为图片的url，设置ImageView的图片的时候，判断tag和url是否一致，一致方可赋值。
如何利用selector、layer-list、shape制作按钮背景。
横屏窗口式界面。
