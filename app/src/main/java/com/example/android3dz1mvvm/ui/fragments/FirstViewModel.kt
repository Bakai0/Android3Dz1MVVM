package com.example.android3dz1mvvm.ui.fragments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android3dz1mvvm.model.FirstModel

@Suppress("UNREACHABLE_CODE", "CAST_NEVER_SUCCEEDS")
class FirstViewModel : ViewModel() {

    private var list: MutableLiveData<ArrayList<FirstModel>> = MutableLiveData()
    fun getListBook(): MutableLiveData<ArrayList<FirstModel>> {

        val bookModelList: ArrayList<FirstModel> = ArrayList()

        bookModelList.add(
            FirstModel(
                "https://static.detmir.st/media_out/494/929/4929494/450/0.jpg?1662437224508",
                " lost World"
            )
        )
        bookModelList.add(
            FirstModel(
                "https://www.mann-ivanov-ferber.ru/assets/images/covers/37/21737/1.00x-thumb.png",
                "Дети капитана Гранта"
            )
        )
        bookModelList.add(
            FirstModel(
                "https://www.storytel.com/images/640x640/0001156746.jpg",
                "самурай без меча"
            )
        )
        bookModelList.add(
            FirstModel(
                "https://img4.labirint.ru/rc/fba9dddb9b67ef95831c7174b4c2eb8c/363x561q80/books16/150746/cover.jpg?1280394613",
                "Гарри Поттер и дары смерти"
            )
        )
        bookModelList.add(
            FirstModel(
                "https://img4.labirint.ru/rc/c5593938783bcf5a3a3617ea89dbf73b/363x561q80/books46/459698/cover.jpg?1566211871",
                "Макс Фрай: чужак"
            )
        )
        bookModelList.add(
            FirstModel(
                "https://cv9.litres.ru/pub/c/cover_200/48428994.jpg",
                "Ведьмин котел"
            )
        )
        list.value = bookModelList
        return list
    }
}
