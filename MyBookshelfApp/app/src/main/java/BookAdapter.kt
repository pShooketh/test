import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class BookAdapter(private val books: List<Book>) : RecyclerView.Adapter<BookAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.book_title)
        val image: ImageView = itemView.findViewById(R.id.book_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val book = books[position]
        holder.title.text = book.volumeInfo.title
        book.volumeInfo.imageLinks?.thumbnail?.let {
            Glide.with(holder.itemView.context).load(it).into(holder.image)
        }
    }

    override fun getItemCount() = books.size
}