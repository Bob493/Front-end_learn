1、如何理解web标准？
Web标准不是某一个标准，而是一系列标准的集合。简单来说，web标准可以分为结构（HTML）、表现（css）、行为（JavaScript）。结构主要是由HTML标签组成，在页面body里面我们写入的标签是为了页面的结构；表现即是css样式表，通过css可以让结构标签变得更具美感；行为指的是页面与用户具有一定的交互，主要由js组成。打个比方，假如把web比作是一辆汽车，那么HTML就是汽车的整体框架构造，css就是汽车的外观表现，JavaScript就是汽车的发动机以及内部构造。
2、JS有哪些数据类型？
JS中的数据分为基本数据类型和引用数据类型。其中基本数据类型分有null、undefined、Boolean、symbol、string、number（Bigint）；引入数据类型中有function、array、object类型。
3、JS中判断数据类型的方法？
（1）typeof()：例如typeof true输出boolean类型，typeof undefined输出undefined类型，这种方法只对基本数据类型有效；
（2）Instanceof():例如”58” instanceof Number输出false，58 instanceof Number输出true，这种方法只是针对引用类型数据，对基本数据类型无效；
（3）Constructor():(“58”).constructor===Number输出true，constructor()方法基本可以满足对基本数据类型和引用数据类型的判断，但是存在特殊情况错误；
（4）Object.prototype.toString.call():Object.prototype.toString.call(58)输出Number类型，这种方法是判断数据类型最完美的方法。
4、正则表达式
RegExp对象表示正则表达式，它是对字符串执行模式匹配的强大工具。
创建RegExp对象的语法：new RegExp(pattern,attributes)；参数pattern是一个字符串，指定了正则表达式的模式或其他正则表达式，参数attributes是一个可选的字符串，包含属性”g”全局匹配、”i”忽略大小写匹配、”m”多行匹配、”s”匹配任何字符（包括终止符”\n”）。
5、“==”和“===”的区别
“==”更多的的值相等
对于相同类型数据的“==”操作，直接比较值并返回true，对于不同类型数据的“==”操作，先转化成相同数据类型在比较值，
若值相等则true，不相等则false，数据类型是否一致并不能影响其结果，“==”结果由值决定，“==”并不是严格意义上的相等；
“===”则注重类型相等且值也要相等
对于不同的数据类型，不管值是否相等直接false，不存在转化成相同数据类型再比较值，对于相同数据类型则比较值是否相等，
相等则true，反之false，“===”的结果是由数据类型和值共同决定，“===”是严格意义上的相等