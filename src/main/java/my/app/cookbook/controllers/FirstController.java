package my.app.cookbook.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {
    @GetMapping("/")
    public String primal() {
        return "Приложение запущено";
    }
    @GetMapping("/info")
    public String info() {
        return "Имя: Кирилл Название проекта: CookBook Дата создания: 08.12.2022 Описание: Проект является поваренной книгой, которая содержит вкусные рецепты, для приготовления блюд";
    }



}
