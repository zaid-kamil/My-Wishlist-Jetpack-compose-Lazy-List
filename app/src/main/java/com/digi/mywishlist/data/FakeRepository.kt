package com.digi.mywishlist.data

class FakeRepository{
    fun getItems(): List<Item>{
        return listOf(
            Item(
                title = "Xbox Game Controller",
                website = "https://www.xbox.com/en-IN/accessories",
                img = "https://assets.xboxservices.com/assets/1d/e9/1de988c2-f32f-4434-a541-f9a4b353ee78.jpg?n=Accessories-Hub_Content-Placement-0_2020-Controller-White_788x444.jpg",
                priority = Priority.High
            ),
            Item(
                title = "meta quest 3",
                website = "https://about.fb.com/news/2023/11/meta-quest-3-holiday-gift-that-transforms-your-home/",
                img = "https://arc-anglerfish-washpost-prod-washpost.s3.amazonaws.com/public/N3MSJXLL7RAQJG6UNQAIXU7URA.gif",
                priority = Priority.Low
            )
        )
    }
}