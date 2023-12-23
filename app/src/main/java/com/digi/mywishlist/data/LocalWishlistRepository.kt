package com.digi.mywishlist.data

class LocalWishlistRepository(private val itemDao: ItemDao) : WishlistRepository {
    override fun getWishlist() = itemDao.getItemList()
    override fun getWishlistItem(id: Int) = itemDao.getItem(id)
    override suspend fun addItem(item: Item) = itemDao.insert(item)
    override suspend fun removeItem(item: Item) = itemDao.delete(item)
    override suspend fun updateItem(item: Item) = itemDao.update(item)
}