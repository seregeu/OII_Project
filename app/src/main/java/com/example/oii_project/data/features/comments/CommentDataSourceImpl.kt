package com.example.oii_project.data.features.comments

import com.example.oii_project.data.dto.CommentDto
import com.example.oii_project.data.features.comments.CommentDataSource

class CommentDataSourceImpl : CommentDataSource {
	override fun getComments() = listOf(
		CommentDto("Василий","А как запустить((((","https://sun9-72.userapi.com/s/v1/ig1/hbHheu1fWOhZilz3Iv_FGmHgfc1cWJRvuD1-LP9m33-RRDNi_0fUUGOcE7q3BR65na4eu_GV.jpg?size=200x200&quality=96&crop=0,0,582,582&ava=1"),
		CommentDto("Артём","Приятная игрушка, хорошие головоломки. Интересная идея прохождения с временным фактором, перекрашиванием пузыриков в цвет исчезающих и физика растяжения пузырей. Очень затягивающая игра!","https://sun9-61.userapi.com/s/v1/if1/NonaICkwbHKQGd-td92BdBcULqkwJvTlHknvin0CeHm0lX63peYSzGfmVuJUgJvFH6WJfsR8.jpg?size=200x200&quality=96&crop=2,2,1495,1495&ava=1"),
		CommentDto("Артём","Приятная игрушка, хорошие головоломки. Интересная идея прохождения с временным фактором, перекрашиванием пузыриков в цвет исчезающих и физика растяжения пузырей. Очень затягивающая игра!","https://sun9-61.userapi.com/s/v1/if1/NonaICkwbHKQGd-td92BdBcULqkwJvTlHknvin0CeHm0lX63peYSzGfmVuJUgJvFH6WJfsR8.jpg?size=200x200&quality=96&crop=2,2,1495,1495&ava=1"),
		CommentDto("Артём","Приятная игрушка, хорошие головоломки. Интересная идея прохождения с временным фактором, перекрашиванием пузыриков в цвет исчезающих и физика растяжения пузырей. Очень затягивающая игра!","https://sun9-61.userapi.com/s/v1/if1/NonaICkwbHKQGd-td92BdBcULqkwJvTlHknvin0CeHm0lX63peYSzGfmVuJUgJvFH6WJfsR8.jpg?size=200x200&quality=96&crop=2,2,1495,1495&ava=1"),
		CommentDto("Артём","Приятная игрушка, хорошие головоломки. Интересная идея прохождения с временным фактором, перекрашиванием пузыриков в цвет исчезающих и физика растяжения пузырей. Очень затягивающая игра!","https://sun9-61.userapi.com/s/v1/if1/NonaICkwbHKQGd-td92BdBcULqkwJvTlHknvin0CeHm0lX63peYSzGfmVuJUgJvFH6WJfsR8.jpg?size=200x200&quality=96&crop=2,2,1495,1495&ava=1"),
		CommentDto("Артём","Приятная игрушка, хорошие головоломки. Интересная идея прохождения с временным фактором, перекрашиванием пузыриков в цвет исчезающих и физика растяжения пузырей. Очень затягивающая игра!","https://sun9-61.userapi.com/s/v1/if1/NonaICkwbHKQGd-td92BdBcULqkwJvTlHknvin0CeHm0lX63peYSzGfmVuJUgJvFH6WJfsR8.jpg?size=200x200&quality=96&crop=2,2,1495,1495&ava=1"),
		CommentDto("Артём","Приятная игрушка, хорошие головоломки. Интересная идея прохождения с временным фактором, перекрашиванием пузыриков в цвет исчезающих и физика растяжения пузырей. Очень затягивающая игра!","https://sun9-61.userapi.com/s/v1/if1/NonaICkwbHKQGd-td92BdBcULqkwJvTlHknvin0CeHm0lX63peYSzGfmVuJUgJvFH6WJfsR8.jpg?size=200x200&quality=96&crop=2,2,1495,1495&ava=1"),
		CommentDto("Артём","Приятная игрушка, хорошие головоломки. Интересная идея прохождения с временным фактором, перекрашиванием пузыриков в цвет исчезающих и физика растяжения пузырей. Очень затягивающая игра!","https://sun9-61.userapi.com/s/v1/if1/NonaICkwbHKQGd-td92BdBcULqkwJvTlHknvin0CeHm0lX63peYSzGfmVuJUgJvFH6WJfsR8.jpg?size=200x200&quality=96&crop=2,2,1495,1495&ava=1"),
		CommentDto("Артём","Приятная игрушка, хорошие головоломки. Интересная идея прохождения с временным фактором, перекрашиванием пузыриков в цвет исчезающих и физика растяжения пузырей. Очень затягивающая игра!","https://sun9-61.userapi.com/s/v1/if1/NonaICkwbHKQGd-td92BdBcULqkwJvTlHknvin0CeHm0lX63peYSzGfmVuJUgJvFH6WJfsR8.jpg?size=200x200&quality=96&crop=2,2,1495,1495&ava=1"),
		CommentDto("Артём","Приятная игрушка, хорошие головоломки. Интересная идея прохождения с временным фактором, перекрашиванием пузыриков в цвет исчезающих и физика растяжения пузырей. Очень затягивающая игра!","https://sun9-61.userapi.com/s/v1/if1/NonaICkwbHKQGd-td92BdBcULqkwJvTlHknvin0CeHm0lX63peYSzGfmVuJUgJvFH6WJfsR8.jpg?size=200x200&quality=96&crop=2,2,1495,1495&ava=1"),
		CommentDto("Алёна","Игра хорошая, но сложность каждой новой головоломки возрастает слишком быстро. Не успеваю получить удовольствие от лёгкой победы. Долго играть не могу, устаю. Но это на мой вкус, может эта игра просто для более умных.","https://sun9-59.userapi.com/s/v1/if1/GefV_dMN-GZ0U0S_z-sUyMalNBAaPjPJFDtLNeTzm0WlkeqSZozEcMoseSL8Y5jENPIQFftj.jpg?size=200x200&quality=96&crop=286,0,604,604&ava=1"),
		CommentDto("Вагиз","Игра очень интересная, но... Прошла все бесплатные уровни и все, дальше будьте любезны заплатить денюшку. Удаляю, так как смысла хранить пройденную игру не вижу.","https://sun9-34.userapi.com/s/v1/ig2/SVgAzv6oEW4VVt-eCdgBdNV1M0fEcsjaehCuugh20q9yS0TsuaNC9GyFFo3ZKLpN7xbKNUCUQen7hppls8wne7OR.jpg?size=200x200&quality=96&crop=1,241,1437,1437&ava=1"),
		CommentDto("Серёжа","Залипательно, приятная графика, но после просмотра рекламы уже третий раз за первый час пользования приложение зависает и помогает только полная перезагрузка.","https://sun9-41.userapi.com/s/v1/if2/wlCXRQnUY2TiN2A62jFMDuN1HTdI7R04ubnE_RuSZpYG15Vxbpsa8KvZ8URqNgTgVOwegklTnYNffLGd0UOnzeN0.jpg?size=200x200&quality=96&crop=140,471,1322,1322&ava=1"),
	)
}