package my.app.cookbook.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Информация")
public class FirstController {

    @Operation(summary = "Статус работы приложения")
    @GetMapping("/")
    public String primal() {
        return "Приложение запущено";
    }

    @Operation(summary = "Информация о приложении")
    @GetMapping("/info")
    public String info() {
        return "Имя: Кирилл Название проекта: CookBook Дата создания: 08.12.2022 Описание: Проект является поваренной книгой, которая содержит вкусные рецепты, для приготовления блюд";
    }


}
