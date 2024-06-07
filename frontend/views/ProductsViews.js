
import { ProductsService } from "../services/products-service.js"

export class ProductsView{
    
    constructor(){}

    async displayProducts(){
        const findall = await ProductsService.findAll()

        findall.forEach(element => {
            console.log(element)
            this.#displayProduct(element)
        });

    }

    #displayProduct(product){
        document.querySelector('.products').innerHTML += 
        "<div class='ligne'><div id='name'>" +
        product.name +
        "</div>" +
        "<div id='owner'>" +
        product.owner +
        "</div>" +
        "<div id='bid'>" +
        product.bid +
        "</div>" +
        "<button id='bouton'>Encherir</button>" +
        "</div></div>"

        document.querySelector('#bouton').addEventListener('click', async () => {
            const bid = await ProductsService.bid(product.id)
        })
        
    }



}
