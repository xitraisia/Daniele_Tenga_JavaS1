const Filter = (title) => `
<form>
    <form id= "title_form">
        <div class="mb-3">
        <label for="title" class="form-label">title</label>
        <input type="title" class="form-control" id="title" name="title">
        </div>
        <button type="submit" class="btn btn-primary">Filter</button>
    </form>
    <form id= "esrb_form">
        <div class="mb-3">
            <label for="esrb_rating" class="form-label">esrb_rating</label>
            <input type="esrb_rating" class="form-control" id="esrb_rating" name="esrb_rating">
        </div>
        <button type="submit" class="btn btn-primary">Filter</button>
    </form>
    <form id= "studio_form">
        <div class="mb-3">
        <label for="studio" class="form-label">studio</label>
        <input type="studio" class="form-control" id="studio" name="studio">
        </div>
        <button type="submit" class="btn btn-primary">Filter</button>
    </form>
</form>
`;
export default Filter;