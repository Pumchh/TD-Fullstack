
import { ProductsService } from "./services/products-service.js"
import { ProductsView } from "./views/ProductsViews.js"

async function run(){

    const view = new ProductsView()

    view.displayProducts()

    
}


run()