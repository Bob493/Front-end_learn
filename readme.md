1、如何理解web标准？
===
Web标准不是某一个标准，而是一系列标准的集合。简单来说，web标准可以分为结构（HTML）、表现（css）、行为（JavaScript）。结构主要是由HTML标签组成，在页面body里面我们写入的标签是为了页面的结构；表现即是css样式表，通过css可以让结构标签变得更具美感；行为指的是页面与用户具有一定的交互，主要由js组成。打个比方，假如把web比作是一辆汽车，那么HTML就是汽车的整体框架构造，css就是汽车的外观表现，JavaScript就是汽车的发动机以及内部构造。

2、JS有哪些数据类型？
===
JS中的数据分为基本数据类型和引用数据类型。其中基本数据类型分有null、undefined、Boolean、symbol、string、number（Bigint）；引入数据类型中有function、array、object类型。

3、JS中判断数据类型的方法？
===
（1）typeof()：例如typeof true输出boolean类型，typeof undefined输出undefined类型，这种方法只对基本数据类型有效；
（2）Instanceof():例如”58” instanceof Number输出false，58 instanceof Number输出true，这种方法只是针对引用类型数据，对基本数据类型无效；
（3）Constructor():(“58”).constructor===Number输出true，constructor()方法基本可以满足对基本数据类型和引用数据类型的判断，但是存在特殊情况错误；
（4）Object.prototype.toString.call():Object.prototype.toString.call(58)输出Number类型，这种方法是判断数据类型最完美的方法。

4、正则表达式
===
RegExp对象表示正则表达式，它是对字符串执行模式匹配的强大工具。
创建RegExp对象的语法：new RegExp(pattern,attributes)；参数pattern是一个字符串，指定了正则表达式的模式或其他正则表达式，参数attributes是一个可选的字符串，包含属性”g”全局匹配、”i”忽略大小写匹配、”m”多行匹配、”s”匹配任何字符（包括终止符”\n”）。

5、“==”和“===”的区别
===
“==”更多的的值相等
对于相同类型数据的“==”操作，直接比较值并返回true，对于不同类型数据的“==”操作，先转化成相同数据类型在比较值，
若值相等则true，不相等则false，数据类型是否一致并不能影响其结果，“==”结果由值决定，“==”并不是严格意义上的相等；
“===”则注重类型相等且值也要相等
对于不同的数据类型，不管值是否相等直接false，不存在转化成相同数据类型再比较值，对于相同数据类型则比较值是否相等，
相等则true，反之false，“===”的结果是由数据类型和值共同决定，“===”是严格意义上的相等。

6、JS数值
===
Math.abs()取绝对值、Math.round()四舍五入、Math.ceil()向上取整、Math.floor()向下取整、Math.max()取最大值、Math.min()取最小值、Math.random()产生随机数(随机数范围为大于等于0小于1)、Math.sqrt()开平方、Math.pow(x,y)指数函数、parseInt(String,radix)把字符串转换成int型，radix为进制，若字符串中遇到非数字则其后忽略，若第一个即为非数字则返回NaN、parseFloat(string)字符串转换成浮点型、Number(value)转换成数字、若其中有非数字则返回NaN、num.toFixed(x)保留x位小数，返回的是一个字符串

7、JS字符串
===
Str.length()获取字符串的长度、str.charAt()获取字符串中某个位置的字符、str.indexOf()查找字符串中是否包含某个字符或字符串，并返回出现的位置，若没有则返回-1、str.replace(x,y)把字符串中的x替换成y，x可以是正则表达式、str.substring(x,y)截取字符串中的一部分字符，包含x不包含y、str.slice(x,y)作用跟substring一样但是可以传入负数表示倒数第几个数、str.substr(x,y)表示从x位置开始截取长度为y的字符串、str.split()切割字符串、str.toLowerCase()把字符串转换成小写、str.toUpperCase()把字符串转换成大写、String()转换成字符串

8、JS对象
===
Obj.hasOwnProperty()判断是否是对象自己所有的属性，是则返回true，不是则返回false，该方法还可用来判断属性是否是继承过来的

9、JS数组
===
arr.reverse()倒序数组、arr.sort()排序数组、arr.push()在数组末尾添加元素、arr.unshift()在数组前面添加元素、arr.shift()获取数组中的第一个元素并删除第一个元素、arr.pop()获取数组中最后一个元素并删除、arr.splice(index,howmany,element)修改数组中任意位置的元素,index表示开始删除的位置，howmany表示删多少，element表示要添加的元素、arr.slice(x,y)表示复制原数组中的一部分，从x开始，不包含y、arr.concat(x,y)把几个数组连接起来、arr.join(x)把数组中的元素用x连接起来、score.map()返回一个新数组

10、Date
===
JS中月份从0开始，如表示2020年4月14日为new Date(2020,3,14)
把Date数据转换成number数据date.getTime()表示date时间距离1970年1月1日0点0分的毫秒数，把number型转换成Date型new Date()或者date.setTime()，传入number即可

11、正则表达式
===
如何定义正则表达式：
(1)/pattern/attrs 规则+属性
(2)new RegExp(pattern,attrs) 传入规则+属性
RegexObj.test(str)测试某字符串是否匹配正则表达式，是则返回true，不是则返回false
锚点：
/^str/:以字符串str为起始
/$str/:以字符串str为结尾
/\bstr\b/:以str为单词边界
字符类：匹配一类字符中的一个[]、.表示任一字符、^表示非
元字符：具有特殊意义的字符
\d:[0-9]          \D:[^\d]
\s:空白符        \S:[^\s]
\w:[A-Za-z0-9]    \W:[^\w]
量词：
{m,n}:出现m到n次
*：{0，}出现0次或多次
？:{0,1}出现0次或1次
+:{1，}出现1次或多次
贪婪模式：匹配尽可能多的字符
惰性模式：在量词之后加上？则匹配尽可能少的字符
多选分支：(str1|str2)匹配str1或str2等价于[str1str2]
捕获：保存匹配到的字符串，以后再用
()表示捕获
(?:)表示不捕获
str.match(regexp):获取匹配的字符串
str.replace(regexp,repalcement):用replacement替换匹配到的字符串
regexpObj.exec(str):更强大的检索，更详尽的结果：index、过程的状态：lastIndex，跟match方法一样也可以获取匹配到的字符串还能获取下一次匹配开始的位置
