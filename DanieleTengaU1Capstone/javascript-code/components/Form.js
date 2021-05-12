const Form = () => `
<form>
    <div class="mb-3">
      <label for="title" class="form-label">title</label>
      <input type="title" class="form-control" id="title" name="title">
    </div>
  <div class="mb-3">
    <label for="esrb_rating" class="form-label">esrb_rating</label>
    <input type="esrb_rating" class="form-control" id="esrb_rating" name="esrb_rating">
  </div>
  <div class="mb-3">
    <label for="description" class="form-label">description</label>
    <input type="description" class="form-control" id="description" name="description">
  </div>
  <div class="mb-3">
  <label for="price" class="form-label">price</label>
  <input type="price" class="form-control" id="price" name="price">
</div>
<div class="mb-3">
<label for="studio" class="form-label">studio</label>
<input type="studio" class="form-control" id="studio" name="studio">
</div>
<div class="mb-3">
<label for="quantity" class="form-label">quantity</label>
<input type="quantity" class="form-control" id="quantity" name="quantity">
</div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
`;
export default Form;
